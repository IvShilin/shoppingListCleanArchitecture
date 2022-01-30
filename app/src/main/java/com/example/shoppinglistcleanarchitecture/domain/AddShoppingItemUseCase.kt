package com.example.shoppinglistcleanarchitecture.domain

class AddShoppingItemUseCase(private val shoppingListRepository: ShoppingListRepository){
    fun addShoppingItem(item: ShoppingItem) {
       shoppingListRepository.addShoppingItem(item)
    }
}