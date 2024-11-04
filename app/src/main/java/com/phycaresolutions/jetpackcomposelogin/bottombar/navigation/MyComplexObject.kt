package com.phycaresolutions.jetpackcomposelogin.bottombar.navigation

class MyComplexObject() {
   private val map = mutableMapOf<String,Any>()
    fun setValue(key: String, value: Any) {
        map[key] = value

        // how to notify about a change? <================
    }

    fun getValue(key: String) : Any? {
        return map[key]
    }

}