package com.enplus.energetic.ui.screen.camera

import android.Manifest
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.enplus.energetic.R
import com.enplus.energetic.ui.components.base.MainButton
import com.enplus.energetic.ui.components.base.TopBarWithReturn
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.Scan
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.util.NavDestinations
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import java.util.concurrent.Executor

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(
    navController: NavController,
    viewModel: CameraViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle(CameraUiState.WaitingForCapture)
    val cameraPermissionState: PermissionState = rememberPermissionState(Manifest.permission.CAMERA)

    if (cameraPermissionState.status.isGranted) {
        CameraScreen(
            uiState = uiState,
            onBackClick = navController::popBackStack,
            onScanClick = viewModel::setLoading,
            onPhotoCaptured = viewModel::recognizeText,
            onRecognized = { text ->
                viewModel.resetState()
                navController.navigate("${NavDestinations.CONFIRMATION_SCREEN}/$text")
            },
        )
    } else {
        NoPermissionScreen(
            onBackClick = navController::popBackStack,
            onRequestPermission = cameraPermissionState::launchPermissionRequest,
        )
    }
}

@Composable
fun CameraScreen(
    uiState: CameraUiState,
    onBackClick: () -> Unit,
    onScanClick: () -> Unit,
    onPhotoCaptured: (ImageProxy) -> Unit,
    onRecognized: (String) -> Unit,
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraController = remember { LifecycleCameraController(context) }

    LaunchedEffect(uiState) {
        when (uiState) {
            is CameraUiState.Error -> {
                Toast.makeText(context, R.string.try_again, Toast.LENGTH_SHORT).show()
            }

            is CameraUiState.Success -> {
                onRecognized(uiState.text)
            }

            else -> {}
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarWithReturn(onBackClick = onBackClick, arrowColor = EnColor.Background)
        },
        bottomBar = {
            BottomBar(
                isLoading = uiState == CameraUiState.Loading,
                onClick = {
                    onScanClick()
                    capturePhoto(context, cameraController, onPhotoCaptured)
                },
            )
        },
    ) { scaffoldPadding ->
        val bottomPadding = scaffoldPadding.calculateBottomPadding() - 18.dp
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = bottomPadding),
            contentAlignment = Alignment.Center,
        ) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    PreviewView(context).apply {
                        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                        setBackgroundColor(Color.BLACK)
                        implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                        scaleType = PreviewView.ScaleType.FILL_CENTER
                    }.also { previewView ->
                        previewView.controller = cameraController
                        cameraController.bindToLifecycle(lifecycleOwner)
                    }
                },
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.camera_bounds),
                contentDescription = null,
                tint = EnColor.Background,
            )
        }
    }
}

@Composable
private fun NoPermissionScreen(
    onBackClick: () -> Unit,
    onRequestPermission: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBarWithReturn(onBackClick = onBackClick)
        },
    ) { scaffoldPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(scaffoldPadding),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(32.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(
                        text = stringResource(R.string.no_permisson),
                        fontSize = 30.sp,
                        fontWeight = FontWeight(700),
                        color = EnColor.TextTitle,
                    )
                    Text(
                        text = stringResource(R.string.no_permission_desc),
                        fontSize = 17.sp,
                        color = EnColor.TextSubtitle,
                    )
                }
                MainButton(
                    onClick = onRequestPermission,
                    icon = Icons.Default.Camera,
                    text = stringResource(R.string.provide_permisson),
                )
            }
        }
    }
}

@Composable
fun BottomBar(
    isLoading: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
            .background(EnColor.Background)
            .padding(16.dp)
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Text(
            text = stringResource(R.string.scan_description),
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = EnColor.TextTitle,
        )

        MainButton(
            text = stringResource(R.string.scan),
            icon = EnIcons.Scan,
            isLoading = isLoading,
            onClick = onClick,
        )
    }
}

private fun capturePhoto(
    context: Context,
    cameraController: LifecycleCameraController,
    onPhotoCaptured: (ImageProxy) -> Unit,
) {
    val mainExecutor: Executor = ContextCompat.getMainExecutor(context)

    cameraController.takePicture(
        mainExecutor,
        object : ImageCapture.OnImageCapturedCallback() {
            override fun onCaptureSuccess(imageProxy: ImageProxy) {
                onPhotoCaptured(imageProxy)
                imageProxy.close()
            }

            override fun onError(exception: ImageCaptureException) {
                Log.e("CameraScreen", "Error capturing image", exception)
            }
        },
    )
}

@Preview(name = "No camera permission screen", showBackground = true)
@Composable
fun NoPermissionScreenPreview() {
    EnergeticTheme {
        NoPermissionScreen(
            onBackClick = {},
            onRequestPermission = {},
        )
    }
}
