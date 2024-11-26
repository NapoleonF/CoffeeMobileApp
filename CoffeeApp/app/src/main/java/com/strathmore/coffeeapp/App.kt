

package com.strathmore.coffeeapp

import androidx.compose.ui.Modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsIgnoringVisibility
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.strathmore.coffeeapp.pages.InfoPage
import com.strathmore.coffeeapp.pages.MenuPage
import com.strathmore.coffeeapp.pages.OffersPage
import com.strathmore.coffeeapp.pages.OrderPage
import com.strathmore.coffeeapp.ui.theme.Alternative1
import com.strathmore.coffeeapp.ui.theme.Alternative2
import com.strathmore.coffeeapp.ui.theme.Alternative3
import com.strathmore.coffeeapp.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
//@Preview
@Composable
fun App(dataManager: DataManager) {
    var selectedRoute by remember{ mutableStateOf("menu") }
        Scaffold(
            modifier = Modifier.windowInsetsPadding(WindowInsets.systemBarsIgnoringVisibility),
            topBar = {

                CenterAlignedTopAppBar(title = {AppTitle()},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Alternative3))
            },
            bottomBar = {

                NavBar(
                    selectedRoute = selectedRoute,
                    onChange = {newRoute-> selectedRoute= newRoute })
            }
        )
        {
            contentPadding ->
            when(selectedRoute){
                Routes.OffersPage.route -> OffersPage(dataManager = dataManager,Modifier.padding(contentPadding))
                Routes.MenuPage.route -> MenuPage(dataManager= dataManager,Modifier.padding(contentPadding))
                Routes.OrderPage.route -> OrderPage(dataManager= dataManager,Modifier.padding(contentPadding))
                Routes.InfoPage.route -> InfoPage(Modifier.padding(contentPadding))
            }
        }


}

@Preview
@Composable
fun AppTitle() {
    Box()
    {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Coffee Logo")
    }

}