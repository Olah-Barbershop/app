package com.olahbarbershop.app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.olahbarbershop.app.data.BottomNavItem
import com.olahbarbershop.app.ui.Navigation
import com.olahbarbershop.app.ui.OlahAppBar
import com.olahbarbershop.app.ui.BottomNavigationBar
import com.olahbarbershop.app.ui.theme.OlahBarbershopTheme

@Composable
fun OlahApp() {
    val navController: NavHostController = rememberNavController()
    Scaffold(
        modifier = Modifier
                .fillMaxSize(),
        topBar = {
                OlahAppBar(
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() },
                    navigateToAbout = { navController.navigate("about")}
                )
        },
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = stringResource(R.string.notifications),
                        route = "notifications",
                        iconSelected = R.drawable.baseline_notifications_24,
                        iconUnSelected = R.drawable.baseline_notifications_none_24
                    ),
                    BottomNavItem(
                        name = stringResource(R.string.locations),
                        route = "locations",
                        iconSelected = R.drawable.baseline_location_on_24,
                        iconUnSelected = R.drawable.outline_location_on_24
                    ),
                    BottomNavItem(
                        name = stringResource(R.string.services),
                        route = "services",
                        iconSelected = R.drawable.baseline_format_list_bulleted_24,
                        iconUnSelected = R.drawable.baseline_format_list_bulleted_24
                    ),
                ),
                navController = navController,
                onItemClick = {
                        navController.navigate(it.route)
                }
            )
        }
    ) { values ->
        Navigation(navController = navController, modifier = Modifier.padding(values))
    }
}