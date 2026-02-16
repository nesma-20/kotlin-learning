package com.example.compose_lec1.Surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FirstApp()

        }



    }


@Preview("Hi", showBackground = true)
@Composable
fun AppReview(modifier: Modifier = Modifier.Companion) {
    FirstApp()
}

    @Composable
    fun FirstApp(){
        Surface(modifier = Modifier.Companion.height(150.dp).width(250.dp).padding(20.dp),
    color = Color.Companion.Green
 , shape = CutCornerShape(16.dp),
    tonalElevation = 8.dp,
    border = BorderStroke(width = 2.dp , Color.Companion.DarkGray),

    ) {
            Text(text = "The following error has ", modifier = Modifier.Companion.padding(16.dp))







}

    }
}