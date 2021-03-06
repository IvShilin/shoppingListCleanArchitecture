package com.example.shoppinglistcleanarchitecture.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglistcleanarchitecture.domain.ShoppingItem
import com.example.shoppinglistcleanarchitecture.domain.ShoppingListRepository
import kotlin.random.Random

object ShoppingListRepositoryImplements : ShoppingListRepository {
    private val shoppingList = sortedSetOf<ShoppingItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private val shoppingListLD = MutableLiveData<List<ShoppingItem>>()

    private var autoIncrementId = 0

    init {
        for (i in 0 until 2) {
            val item = ShoppingItem("Name $i", i, Random.nextBoolean())
            addShoppingItem(item)
        }
    }

    override fun addShoppingItem(item: ShoppingItem) {
        if (item.id == ShoppingItem.UNDEFINED_ID) {
            item.id = autoIncrementId++
        }
        shoppingList.add(item)
        updateList()
    }

    override fun deleteShoppingItem(item: ShoppingItem) {
        shoppingList.remove(item)
        updateList()
    }

    override fun editShoppingItemCase(item: ShoppingItem) {
        val oldItem = getShoppingItem(item.id)
        shoppingList.remove(oldItem)
        addShoppingItem(item)
    }

    override fun getShoppingItem(id: Int): ShoppingItem {
        return shoppingList.find { it.id == id }
            ?: throw RuntimeException("Shopping list id $id is null")
    }

    override fun getShoppingList(): LiveData<List<ShoppingItem>> {
        return shoppingListLD
    }

    private fun updateList() {
        shoppingListLD.value = shoppingList.toList()
    }
}