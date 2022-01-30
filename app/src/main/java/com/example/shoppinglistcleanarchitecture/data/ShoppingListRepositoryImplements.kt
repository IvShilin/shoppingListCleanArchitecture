package com.example.shoppinglistcleanarchitecture.data

import com.example.shoppinglistcleanarchitecture.domain.ShoppingItem
import com.example.shoppinglistcleanarchitecture.domain.ShoppingListRepository
import java.lang.RuntimeException

object ShoppingListRepositoryImplements: ShoppingListRepository{
    private val shoppingList = mutableListOf<ShoppingItem>()
    private var autoIncrementId = 0

    override fun addShoppingItem(item: ShoppingItem) {
        if (item.id == ShoppingItem.UNDEFIND_ID) { item.id = autoIncrementId++ }
        shoppingList.add(item)
    }

    override fun deleteShoppingItem(item: ShoppingItem) {
        shoppingList.remove(item)
    }

    override fun editShoppingItemCase(item: ShoppingItem) {
        val oldItem = getShoppingItem(item.id)
        shoppingList.remove(oldItem)
        addShoppingItem(item)
    }

    override fun getShoppingItem(id: Int): ShoppingItem {
        return shoppingList.find { it.id == id }
            ?:
            throw RuntimeException("Shopping list id $id is null")
    }

    override fun getShoppingList(): List<ShoppingItem> {
        return shoppingList.toList()
    }
}