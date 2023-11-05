package com.enplus.energetic.ui.screen.main

import android.Manifest
import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.enplus.energetic.R
import com.enplus.energetic.ui.components.base.MainButton
import com.enplus.energetic.ui.components.base.TextField
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.Logout
import com.enplus.energetic.ui.icon.Scan
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.ui.util.NavDestinations
import com.enplus.energetic.util.goToAppSetting

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val activity = LocalContext.current as Activity

    val openAlertDialog = remember { mutableStateOf(false) }

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (!isGranted) {
                openAlertDialog.value = true
            } else {
                navController.navigate(NavDestinations.CAMERA_SCREEN)
            }
        },
    )

    if (openAlertDialog.value) {
        NoPermissionAlert(
            isPermissionDeclined = !activity.shouldShowRequestPermissionRationale(Manifest.permission.CAMERA),
            onDismissRequest = { openAlertDialog.value = false },
            onConfirmation = {
                openAlertDialog.value = false
                cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            },
            onGoToAppSettingsClick = {
                openAlertDialog.value = false
                activity.goToAppSetting()
            },
        )
    }

    LaunchedEffect(uiState) {
        when (uiState) {
            is MainUiState.Success -> {
                navController.navigate("${NavDestinations.DATA_SCREEN}/${(uiState as MainUiState.Success).personData}")
                viewModel.resetState()
            }

            else -> {
            }
        }
    }

    // TODO add get name useCase
    MainScreen(
        username = "Ирина А.",
        uiState = uiState,
        onScanClick = { cameraPermissionLauncher.launch(Manifest.permission.CAMERA) },
        onSearchClick = viewModel::getPersonData,
    )
}

@Composable
fun MainScreen(
    username: String,
    uiState: MainUiState,
    onScanClick: () -> Unit,
    onSearchClick: (searchValue: String) -> Unit,
) {
    var searchValue by rememberSaveable { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = EnColor.Orange,
        topBar = {
            AppBar(
                title = username,
                onLogoutClick = {},
            )
        },
    ) { scaffoldPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = scaffoldPadding.calculateTopPadding())
                .background(
                    color = EnColor.Background,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                )
                .padding(start = 24.dp, top = 32.dp, end = 24.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = stringResource(R.string.main_page_search_title),
                    fontSize = 30.sp,
                    fontWeight = FontWeight(700),
                    color = EnColor.TextTitle,
                )
                Text(
                    text = stringResource(R.string.main_page_search_description),
                    fontSize = 17.sp,
                    color = EnColor.TextSubtitle,
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                TextField(
                    value = searchValue,
                    onValueChange = { searchValue = it },
                    placeholder = stringResource(R.string.main_page_search_placeholder),
                )
                MainButton(
                    text = stringResource(R.string.main_page_find_button_text),
                    onClick = {
                        onSearchClick(searchValue)
                    },
                    isEnabled = searchValue.isNotBlank(),
                    isLoading = uiState == MainUiState.Loading,
                )
            }
            MainButton(
                text = stringResource(R.string.main_page_scan_button_text),
                icon = EnIcons.Scan,
                colors = ButtonDefaults.buttonColors(
                    containerColor = EnColor.OrangeContainer,
                    contentColor = EnColor.Orange,
                ),
                onClick = onScanClick,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    title: String,
    onLogoutClick: () -> Unit,
) {
    TopAppBar(
        modifier = Modifier.padding(vertical = 8.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = EnColor.Orange,
            titleContentColor = EnColor.TextOnDark,
        ),
        title = {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
            )
        },
        actions = {
            IconButton(onClick = onLogoutClick) {
                Icon(
                    imageVector = EnIcons.Logout,
                    contentDescription = "Logout Button",
                    tint = EnColor.TextOnDark,
                )
            }
        },
    )
}

@Composable
private fun NoPermissionAlert(
    isPermissionDeclined: Boolean,
    onConfirmation: () -> Unit,
    onDismissRequest: () -> Unit,
    onGoToAppSettingsClick: () -> Unit,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = EnColor.Background,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp,
            ),
            shape = RoundedCornerShape(size = 8.dp),
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 16.dp,
                    end = 20.dp,
                    bottom = 20.dp,
                    start = 20.dp,
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    text = stringResource(R.string.no_permission_alert_title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    color = EnColor.TextTitle,
                )
                Text(
                    text = stringResource(R.string.no_permission_alert_desc),
                    fontSize = 16.sp,
                    color = EnColor.TextTitle,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 8.dp,
                        alignment = Alignment.End,
                    ),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        modifier = Modifier
                            .offset(x = 8.dp, y = 4.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable { onDismissRequest() }
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        text = stringResource(R.string.no_permission_alert_cancel_button),
                        color = EnColor.Blue,
                    )
                    Text(
                        modifier = Modifier
                            .offset(x = 8.dp, y = 4.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable {
                                if (isPermissionDeclined) {
                                    onGoToAppSettingsClick()
                                } else {
                                    onConfirmation()
                                }
                            }
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        text = stringResource(R.string.no_permission_alert_good_button),
                        color = EnColor.Blue,
                    )
                }
            }
        }
    }
}

@Preview(name = "Main screen")
@Composable
fun MainScreenPreview() {
    EnergeticTheme {
        MainScreen(
            username = "Ирина А.",
            uiState = MainUiState.Waiting,
            onScanClick = {},
            onSearchClick = {},
        )
    }
}

@Preview(name = "No permission alert")
@Composable
fun NoPermissionAlertPreview() {
    EnergeticTheme {
        NoPermissionAlert(
            isPermissionDeclined = false,
            onDismissRequest = {},
            onConfirmation = {},
            onGoToAppSettingsClick = {},
        )
    }
}
