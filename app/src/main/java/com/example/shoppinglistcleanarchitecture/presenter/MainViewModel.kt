package com.example.shoppinglistcleanarchitecture.presenter

import androidx.lifecycle.ViewModel
import com.example.shoppinglistcleanarchitecture.data.ShoppingListRepositoryImplements
import com.example.shoppinglistcleanarchitecture.domain.DeleteShoppingItemUseCase
import com.example.shoppinglistcleanarchitecture.domain.EditShoppingItemUseCase
import com.example.shoppinglistcleanarchitecture.domain.GetShoppingListUseCase
import com.example.shoppinglistcleanarchitecture.domain.ShoppingItem

class MainViewModel : ViewModel() {
    private val repository = ShoppingListRepositoryImplements

    private val getShoppingListUseCase = GetShoppingListUseCase(repository)
    private val deleteShoppingItemUseCase = DeleteShoppingItemUseCase(repository)
    private val editShoppingItemUseCase = EditShoppingItemUseCase(repository)

    var shoppingList = getShoppingListUseCase.getShoppingList()

    fun deleteShoppingItem(item: ShoppingItem){
        deleteShoppingItemUseCase.deleteShoppingItem(item)
    }

    fun editShopList(item: ShoppingItem){
        val editItem = item.copy(enabled = !item.enabled)
        editShoppingItemUseCase.editShoppingItemCase(editItem)
    }
}