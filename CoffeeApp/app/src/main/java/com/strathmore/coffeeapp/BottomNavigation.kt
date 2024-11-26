package com.strathmore.coffeeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.strathmore.coffeeapp.ui.theme.Alternative1
import com.strathmore.coffeeapp.ui.theme.Alternative2
import com.strathmore.coffeeapp.ui.theme.Alternative3
import com.strathmore.coffeeapp.ui.theme.OnPrimary

data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    var MenuPage = NavPage("Menu", Icons.Outlined.Menu,"menu")
    var OffersPage = NavPage("Offers", Icons.Outlined.Star, "offers")
    var OrderPage = NavPage("My Orders", Icons.Outlined.ShoppingCart, "orders")
    var InfoPage = NavPage("Info", Icons.Outlined.Info, "info")

    var pages = listOf(MenuPage, OffersPage, OrderPage, InfoPage)
}


//@Preview
@Composable
fun NavBar(selectedRoute: String= Routes.MenuPage.route,
           onChange:(String)-> Unit,
           modifier: Modifier = Modifier

){
    Row( horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Alternative3)
    ) {
        for(pages in Routes.pages){
            NavBarItem(page = pages,
            selected=selectedRoute==pages.route,
            modifier = Modifier.clickable { onChange(pages.route) }
            )
        }
    }
}


@Composable
fun NavBarItem(page: NavPage, selected: Boolean = false, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)
    ) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Alternative1 else OnPrimary
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(
            text = page.name,
            fontSize = 12.sp,
            color = if (selected) Alternative1 else OnPrimary
        )
    }
}
