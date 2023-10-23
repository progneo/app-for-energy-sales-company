package com.enplus.energetic.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enplus.energetic.R
import com.enplus.energetic.ui.components.base.MainButton
import com.enplus.energetic.ui.components.base.TextField
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.Logout
import com.enplus.energetic.ui.icon.Scan
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.util.NavDestinations

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel(),
) {
    MainScreen(
        username = "Ирина А.",
        onScanClick = {
            navController.navigate(NavDestinations.CAMERA_SCREEN)
        },
    )
}

@Composable
fun MainScreen(
    username: String,
    onScanClick: () -> Unit,
) {
    var searchValue by rememberSaveable { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = EnColor.Orange,
        topBar = {
            AppBar(
                title = username,
                itemsColor = EnColor.TextOnDark,
                onIconClick = {},
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
                    text = stringResource(R.string.search_title),
                    fontSize = 30.sp,
                    fontWeight = FontWeight(700),
                    color = EnColor.TextTitle,
                )
                Text(
                    text = stringResource(R.string.search_description),
                    fontSize = 17.sp,
                    color = EnColor.TextSubtitle,
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                TextField(
                    value = searchValue,
                    onValueChange = { searchValue = it },
                    placeholder = stringResource(R.string.main_search_placeholder),
                )
                MainButton(
                    text = stringResource(R.string.find),
                    onClick = { },
                )
            }
            MainButton(
                text = stringResource(R.string.scan),
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

@Composable
private fun AppBar(title: String, itemsColor: Color, onIconClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(vertical = 26.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            modifier = Modifier
                .height(32.dp)
                .weight(1f),
            text = title,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = itemsColor,
            ),
        )
        IconButton(
            modifier = Modifier.requiredSize(32.dp),
            onClick = onIconClick,
        ) {
            Icon(
                imageVector = EnIcons.Logout,
                contentDescription = "Logout Button",
                tint = itemsColor,
            )
        }
    }
}

@Preview(name = "Main screen")
@Composable
fun MainScreenPreview() {
    EnergeticTheme {
        MainScreen(
            username = "Ирина А.",
            onScanClick = {},
        )
    }
}
