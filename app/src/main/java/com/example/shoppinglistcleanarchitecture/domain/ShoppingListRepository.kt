package com.example.shoppinglistcleanarchitecture.domain

interface ShoppingListRepository {
    fun addShoppingItem(item: ShoppingItem)

    fun deleteShoppingItem(item: ShoppingItem)

    fun editShoppingItemCase(item: ShoppingItem)

    fun getShoppingItem(id: Int) : ShoppingItem

    fun getShoppingList() : List<ShoppingItem>
}