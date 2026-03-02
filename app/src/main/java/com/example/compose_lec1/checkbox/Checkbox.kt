package com.example.compose_lec1.checkbox

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Checkbox : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        val checkedState = remember { mutableStateOf(true) }

        Column(
            modifier = Modifier.Companion
                .fillMaxSize()
                .background(Color.Companion.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Companion.CenterHorizontally
        ) {


            val fruitlist = arrayListOf("Apple", "Mango", "Orange")
            val context = LocalContext.current
            fruitlist.forEach { option: String ->
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Companion.CenterVertically
                ) {
                    Checkbox(
//                        modifier = Modifier.scale(1f),
//                        colors = CheckboxDefaults.colors(
//                            checkedColor = Color.Blue ,
//                            checkmarkColor = Color.Yellow,
//                            uncheckedColor = Color.Black
//                        ),
                        checked = checkedState.value,
                        onCheckedChange = {
                            Toast.makeText(context, option, Toast.LENGTH_LONG).show()
                            checkedState.value = it
                        }

                    )
                    Spacer(modifier = Modifier.Companion.size(16.dp))
                    Text(option)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun AppPreview() {
        MyApp()
    }
}