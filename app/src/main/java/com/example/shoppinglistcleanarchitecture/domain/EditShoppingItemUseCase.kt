package com.example.shoppinglistcleanarchitecture.domain

class EditShoppingItemUseCase(private val shoppingListRepository: ShoppingListRepository) {
    fun editShoppingItem(item: ShoppingItem) {
        shoppingListRepository.editShoppingItemCase(item)
    }
}