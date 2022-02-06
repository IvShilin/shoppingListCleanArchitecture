package com.example.shoppinglistcleanarchitecture.domain

class DeleteShoppingItemUseCase(private val shoppingListRepository: ShoppingListRepository) {
    fun deleteShoppingItem(item: ShoppingItem) {
        shoppingListRepository.deleteShoppingItem(item)
    }
}