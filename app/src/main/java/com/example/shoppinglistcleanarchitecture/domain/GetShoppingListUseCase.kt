package com.example.shoppinglistcleanarchitecture.domain

class GetShoppingListUseCase(private val shoppingListRepository: ShoppingListRepository) {
    fun getShoppingList() : List<ShoppingItem>{
        return shoppingListRepository.getShoppingList()
    }
}