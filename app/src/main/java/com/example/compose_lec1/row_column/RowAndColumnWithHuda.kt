package com.example.compose_lec1.row_column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

class RowAndColumnWithHuda : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Column(
                modifier = Modifier.background(color =
                    Color.Green).fillMaxSize(
                    0.50f)
                    .width(200.dp)
                   .height(300.dp)
               //     .requiredWidth(600.dp)
//بتاخد طول وعرض
                //    .fillMaxWidth().fillMaxHeight()
                    .padding(
                        end = 30.dp,
                       bottom =  30.dp,
                        start = 20.dp,
                        top = 30.dp
                        )
                    .offset()
                    .border(2.dp, Color.Red)
                    .clickable(onClick = {
                        print("nesma")
                    })
            ){
                Text(text = "test")
                Text(text = "Hello World")
            }



        }



    }}