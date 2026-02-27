package com.example.compose_lec1.firstApp
import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
       //  Greeting(name = "Hello Nesma")

//            Column(
//                modifier = Modifier.fillMaxSize(0.5f)
//                    .width(200.dp)
//                    .background(Color.Green) ,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceBetween ,
//
//            ) {
//
//
//                Text("Hello", modifier = Modifier.padding(16.dp))
//                Text("World", modifier = Modifier.padding(16.dp))
//                Text("World", modifier = Modifier.padding(16.dp))
//
//
//
//            }

            Row (
                modifier = Modifier.fillMaxSize(0.5f)
                    .width(200.dp).background(Color.Green) ,
                horizontalArrangement  = Arrangement.SpaceBetween,
                verticalAlignment= Alignment.CenterVertically ,

                ) {


                Text("Hello", modifier = Modifier.padding(16.dp))
                Text("World", modifier = Modifier.padding(16.dp))
                Text("World", modifier = Modifier.padding(16.dp))



            }


        }

    }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

  //  Greeting("Nesma")


}
@Composable
fun  Greeting(name : String) {

//Text(text = "Hello $name")


}

