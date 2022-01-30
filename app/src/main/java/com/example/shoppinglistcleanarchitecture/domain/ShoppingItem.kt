package com.example.shoppinglistcleanarchitecture.domain

data class ShoppingItem (
    val name : String,
    val id : Int,
    val count : Int,
    val enabled : Boolean
        )