package com.example.shoppinglistcleanarchitecture.domain

import androidx.lifecycle.LiveData

interface ShoppingListRepository {
    fun addShoppingItem(item: ShoppingItem)

    fun deleteShoppingItem(item: ShoppingItem)

    fun editShoppingItemCase(item: ShoppingItem)

    fun getShoppingItem(id: Int): ShoppingItem

    fun getShoppingList(): LiveData<List<ShoppingItem>>
}