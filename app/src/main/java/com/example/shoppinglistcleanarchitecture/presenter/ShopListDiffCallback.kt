package com.example.shoppinglistcleanarchitecture.presenter

import androidx.recyclerview.widget.DiffUtil
import com.example.shoppinglistcleanarchitecture.domain.ShoppingItem

class ShopListDiffCallback(
    private val oldList: List<ShoppingItem>,
    private val newList: List<ShoppingItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
       return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem  = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem  = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }
}