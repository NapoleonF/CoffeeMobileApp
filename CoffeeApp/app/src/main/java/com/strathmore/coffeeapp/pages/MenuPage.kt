package com.strathmore.coffeeapp.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.strathmore.coffeeapp.Product
import com.strathmore.coffeeapp.R
import com.strathmore.coffeeapp.ui.theme.Alternative1
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.strathmore.coffeeapp.DataManager
import com.strathmore.coffeeapp.addCart
import com.strathmore.coffeeapp.ui.theme.CardBackground
import com.strathmore.coffeeapp.ui.theme.Primary


//@Preview
@Composable
fun MenuPage(dataManager: DataManager,modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
       items(dataManager.menu){
           Text(it.name,
               color = Primary,
               modifier = Modifier.padding(10.dp,20.dp,10.dp, 10.dp)
           )
           it.products.forEach{
               Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                   shape = RoundedCornerShape(12.dp),
                   modifier = Modifier
                       .background(CardBackground)
                       .padding(12.dp)
               ){
                   ProductItem(product = it, onAdd = { addCart(dataManager, it) })
               }

           }
       }


    }
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("$${product.price.format(2)} ea")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Alternative1,
                    contentColor = Color.White
                ),
                onClick = {
                    onAdd(product)
                },
            ) {
                Text("Add")
            }
        }
    }
}