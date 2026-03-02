package com.example.compose_lec1.Modifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Modifiers : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  enableEdgeToEdge()

        setContent {
            MyApp()

        }


    }


    @Composable
    fun MyApp() {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            Text(
                "modifier",
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.Green)
                    .padding(10.dp)
                    .width(200.dp)
                    .height(200.dp)
                //  .fillMaxWidth()
                // .fillMaxHeight()

            )

            Box(
                modifier =

                    Modifier
                        .padding(start = 50.dp, top = 30.dp)
                        .size(150.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .alpha(0.7f)
                        .background(Color.Cyan)
                        .border(
                            width = 2.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(16.dp)
                        ).clickable{

                        }
            ) {

            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun AppPreview() {
        MyApp()
    }
}