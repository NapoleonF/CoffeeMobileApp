package com.strathmore.coffeeapp

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class DataManager(app: Application): AndroidViewModel(app)
{
    var menu: List<Category> by mutableStateOf(listOf())
    var cart: List<ItemInCart> by mutableStateOf(listOf())
    init {
        fetchData()
    }
    fun fetchData(){
        viewModelScope.launch{
            menu = API.API.menuService.fetchMenu()
        }

    }

}

fun addCart(dataManager: DataManager, product: Product){
    var found = false
    dataManager.cart.forEach{
        if(product.id==it.product.id){
            it.quantity++
            found = true
        }
    }
    if(!found){
        dataManager.cart = dataManager.cart + ItemInCart(product, quantity = 1)
    }
}

fun cartDecrement(dataManager: DataManager, product: Product) {
    val updatedCart = dataManager.cart.toMutableList()
    updatedCart.forEach {
        if (it.product.id == product.id) {
            if (it.quantity > 1) {
                it.quantity--
            } else {
                updatedCart.remove(it)
            }
            return@forEach
        }
    }
    dataManager.cart = updatedCart
}


