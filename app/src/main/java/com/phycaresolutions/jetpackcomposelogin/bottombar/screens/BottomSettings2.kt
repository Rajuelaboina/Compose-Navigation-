package com.phycaresolutions.jetpackcomposelogin.bottombar.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.phycaresolutions.jetpackcomposelogin.R

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun BottomSettings2() {
    val context = LocalContext.current.applicationContext
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("1")}
    val listOfQuality = listOf("1","2","3","4","more")
    var selectedItemIndex by remember { mutableStateOf(0) }
    var textfieldSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp//it requires androidx.compose.material:material-icons-extended
    else
        Icons.Filled.KeyboardArrowDown

    Column(modifier = Modifier.padding(top=120.dp, start = 20.dp, end = 20.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
           Column {
               Image(painterResource(id = R.drawable.doctor),
                   modifier = Modifier
                       .height(100.dp)
                       .width(100.dp),
                   contentDescription ="" )




               /* Row(modifier = Modifier
                    .border(
                        border = ButtonDefaults.outlinedBorder,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center)
                {

                    Text(text = "Quat",
                        modifier = Modifier.width(50.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,)

                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded },
                        modifier = Modifier
                            .padding(0.dp)
                            .width(80.dp)
                            .background(color = Color.White),
                    ) {
                        TextField(
                            value = selectedText,
                            onValueChange = {selectedText = it},
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        )

                        ExposedDropdownMenu(
                            modifier = Modifier.background(Color(44, 44, 44)),
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            listOfQuality.forEachIndexed { index, item ->
                                androidx.compose.material3.DropdownMenuItem(
                                    modifier = Modifier.background(color = Color.Red),
                                    text = { Text(text = item,
                                        style = TextStyle(
                                            color = Color.Black,
                                            //drawStyle = Stroke(),
                                        ),) },
                                    onClick = {
                                        selectedText = item
                                        expanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()

                                    }
                                )
                            }
                        }
                   // 2800-1860=940
                   //
                }
               }*/

               Column(modifier = Modifier
                   .width(100.dp),) {
                   OutlinedTextField(value = selectedText, onValueChange = { selectedText = it},
                       modifier = Modifier
                           .fillMaxWidth()
                           .onGloballyPositioned { coordinates ->
                               //This value is used to assign to the DropDown the same width
                               textfieldSize = coordinates.size.toSize()
                           },
                       label = {Text("Quantity")},
                       trailingIcon = {
                           Icon(icon,"contentDescription",
                               Modifier.clickable { expanded = !expanded })
                       }
                   )
                   DropdownMenu(
                       expanded = expanded,
                       onDismissRequest = { expanded = false },
                       modifier = Modifier
                           .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                   ) {
                       listOfQuality.forEach { item ->
                           DropdownMenuItem(onClick = {
                               selectedText = item
                               expanded = false
                               Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                           }) {
                               Text(text = item)
                           }
                       }
                   }
               }

           }

            Column {
                Text(text = "Product name", fontSize = 18.sp,)

                Row(
                    modifier = Modifier.padding(top = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = Icons.Outlined.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFDA45)
                    )
                    androidx.compose.material3.Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = "4.5",
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontSize = 12.sp,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )

                }
                Column(modifier = Modifier.padding(start = 8.dp, end = 10.dp)) {
                    Text(text = "Rs 1100", fontSize = 15.sp,)
                    Text(text = "Rs 800", fontSize = 14.sp,
                        textDecoration = TextDecoration.LineThrough,
                        modifier = Modifier.padding(start = 10.dp))
                }

            }



        }




   }

    //
    //
}