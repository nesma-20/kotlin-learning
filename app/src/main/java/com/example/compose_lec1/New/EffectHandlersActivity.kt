package com.example.compose_lec1.New

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class EffectHandlersActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {


            Column(modifier = Modifier.padding(92.dp)) {


                var textState: String by remember {
                    mutableStateOf("hello")
                }


                Button(onClick = {
                    textState = "Hello Nesma"
                }) {

                    Text("Click me")

                }
                FirstComposable(textState)
            }


        }

    }
}

@Composable
fun FirstComposable(

    state: String
) {
    Text(state, color = Color.Red)
}

@Preview()
@Composable
fun Preview() {
     FirstComposable("test")
}
