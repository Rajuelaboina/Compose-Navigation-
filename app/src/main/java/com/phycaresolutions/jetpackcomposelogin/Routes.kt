package com.phycaresolutions.jetpackcomposelogin

sealed class Routes(val route: String) {
    object LoginScreen : Routes("LoginScreen")
    object HomeScreen : Routes("HomeScreen")

} 