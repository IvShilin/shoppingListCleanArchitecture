package com.example.shoppinglistcleanarchitecture.domain

class EditShoppingItemUseCase(private val shoppingListRepository: ShoppingListRepository) {
    fun editShoppingItemCase(item: ShoppingItem){
        shoppingListRepository.editShoppingItemCase(item)
    }
}