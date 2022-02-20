package com.example.shoppinglistcleanarchitecture.presenter

import androidx.recyclerview.widget.DiffUtil
import com.example.shoppinglistcleanarchitecture.domain.ShoppingItem

class ShopItemDiffCallback : DiffUtil.ItemCallback<ShoppingItem>() {
    override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
        return oldItem == newItem
    }
}