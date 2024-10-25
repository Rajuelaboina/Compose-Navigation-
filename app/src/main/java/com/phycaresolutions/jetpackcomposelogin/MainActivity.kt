package com.phycaresolutions.jetpackcomposelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.phycaresolutions.jetpackcomposelogin.bottombar.navigation.BottomRoute
import com.phycaresolutions.jetpackcomposelogin.productsui.NavigationItem
import com.phycaresolutions.jetpackcomposelogin.ui.theme.JetPackComposeLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeLoginTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    // --------    navigation one to many ______________________________ //
                  // AppNavHost(navController = navController, startDestination = NavigationItem.LOGIN)
                    AppNavHost(navController = navController, startDestination = BottomRoute.LOGIN)

                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeLoginTheme {
       // Greeting("Android")
     //  UserLogin(modifier = Modifier)
        val navController = rememberNavController()
        LoginScreen(navController = navController)
    }
}
// https://dummyjson.com/
// https://cran.r-project.org/web/packages/jsonlite/vignettes/json-apis.html     jsonapi examples
// https://github.com/KaushalVasava/ComposeUI/blob/master/app/src/main/java/com/kaushalvasava/app/composeui/ui/navigation/NavigationItem.kt