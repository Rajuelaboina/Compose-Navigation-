package com.phycaresolutions.jetpackcomposelogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.phycaresolutions.jetpackcomposelogin.bottombar.navigation.BottomRoute
import com.phycaresolutions.jetpackcomposelogin.productsui.NavigationItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {
    val msg = navController.currentBackStackEntry?.savedStateHandle?.get<String>("msg")
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var context = LocalContext.current.applicationContext
    var passwordvisible by rememberSaveable { mutableStateOf(false) }
    var isClicked by remember {  mutableStateOf(false) }
    var isProgressShowing by rememberSaveable { mutableStateOf(false)}
    val scope = rememberCoroutineScope()
    Column {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(0.dp)
                    .align(Alignment.CenterHorizontally),
            ) {
                TextField(value = text,
                    onValueChange = { text =it},
                    label = { Text(text = "Username") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )
                TextField(value = password,
                    onValueChange = { password =it},
                    label = { Text(text = "Password") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (passwordvisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        if (passwordvisible)                              // Icon(imageVector = , contentDescription = )
                            Image(painterResource(id =  R.drawable.baseline_visibility_24), contentDescription = "visible on" )
                        else
                            Image(painterResource(id =  R.drawable.baseline_visibility_off_24), contentDescription = "visible off" )

                        IconButton(onClick = { passwordvisible=!passwordvisible }) {
                        }
                    }
                )
                Button(modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    onClick = {
                        isProgressShowing =true
                        scope.launch {
                            delay(2000)
                            navController.previousBackStackEntry?.savedStateHandle?.set("msg", text)
                            //navController.popBackStack()
                            //navController.navigate(NavigationItem.PRODUCT)
                            navController.navigate(BottomRoute.HOME)
                            isProgressShowing =false
                        }


                    }
                ){
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        if (isProgressShowing) {
                            CircularProgressIndicator(
                                color = Color.White,
                                modifier = Modifier.size(ButtonDefaults.IconSize),
                                strokeWidth = 2.dp
                            )
                        }
                        Text(text = "Login")
                    }

                    /* Spacer(modifier = Modifier.height(8.dp))
                     msg?.let {
                         Text(it)
                     }*/
                }
            }
        }
    }
}