package com.phycaresolutions.jetpackcomposelogin.bottombar.navigation

interface CartItem {
    fun cartCount(count: Int)
    companion object: CartItem{
        var cc = 0
        override fun cartCount(count: Int) {
             cc = count
        }

    }
}