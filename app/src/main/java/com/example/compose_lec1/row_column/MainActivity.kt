package com.example.compose_lec1.row_column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {


        }



    }}



@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Row(

//        modifier=
//        Modifier.fillMaxSize()
        Modifier.width(100.dp)
           .height(150.dp).background(Color.Green),
//       ,
        verticalAlignment =  Alignment.CenterVertically,
        horizontalArrangement=Arrangement.SpaceAround) {
        Text(text =  "Hello")
        Text(text =  "Hello")

    }

}


@Composable
fun MyAppp(modifier: Modifier = Modifier) {
    Column (
//        modifier=
//        Modifier.fillMaxSize()
        Modifier.width(100.dp)
            .height(100.dp).background(Color.Yellow)
//            .background(Color.White) ,
       , verticalArrangement =  Arrangement.SpaceBetween,
        horizontalAlignment= Alignment.CenterHorizontally,

    ) {
        Text(text =  "Nesmafdsaffdvgszva")
        Text(text =  "test")

    }

}


@Preview(showBackground = true)
@Composable
fun AppPreview(modifier: Modifier = Modifier) {
  Column() {

      MyApp()
      MyAppp()
  }
}


