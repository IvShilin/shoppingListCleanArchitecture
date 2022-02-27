package com.example.shoppinglistcleanarchitecture.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglistcleanarchitecture.data.ShoppingListRepositoryImplements
import com.example.shoppinglistcleanarchitecture.domain.AddShoppingItemUseCase
import com.example.shoppinglistcleanarchitecture.domain.EditShoppingItemUseCase
import com.example.shoppinglistcleanarchitecture.domain.GetShoppingItemUseCase
import com.example.shoppinglistcleanarchitecture.domain.ShoppingItem

class ShopItemViewModel : ViewModel() {
    private val repository = ShoppingListRepositoryImplements

    private val getShopItemUseCase = GetShoppingItemUseCase(repository)
    private val addShopItemUseCase = AddShoppingItemUseCase(repository)
    private val editShopItemUseCase = EditShoppingItemUseCase(repository)

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shopItem = MutableLiveData<ShoppingItem>()
    val shopItem: LiveData<ShoppingItem>
        get() = _shopItem

    private val _finishActivity = MutableLiveData<Unit>()
    val finishActivity: LiveData<Unit>
        get() = _finishActivity


    fun getShopItem(shopItemId: Int) {
        val item = getShopItemUseCase.getShoppingItem(shopItemId)
        _shopItem.value = item
    }

    fun addShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)

        if (fieldsValid) {
            val item = ShoppingItem(name, count, true)
            addShopItemUseCase.addShoppingItem(item)
        }

        finishActivity()
    }

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)

        if (fieldsValid) {
            _shopItem.value?.let {
                val item = it.copy(name = name, count = count)
                editShopItemUseCase.editShoppingItem(item)
                finishActivity()
            }
        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (count <= 0) {
            _errorInputCount.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInputName.value = false
    }

    fun resetErrorInputCount() {
        _errorInputCount.value = false
    }

    fun finishActivity() {
        _finishActivity.value = Unit
    }
}