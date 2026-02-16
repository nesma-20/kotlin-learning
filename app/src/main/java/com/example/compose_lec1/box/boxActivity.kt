package com.example.compose_lec1.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.sp
import com.example.compose_lec1.row_column.MyApp


class boxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {


        }



    }}



@Composable
fun MyAppp(modifier: Modifier = Modifier) {

    Box(modifier =
        Modifier.background(Color.Yellow).fillMaxSize(), contentAlignment = Alignment.Center){
        Box(modifier =
            Modifier.background(Color.Green).width(200.dp).height(200.dp),contentAlignment=
            Alignment.Center){
            Box(modifier = Modifier.background(Color.Blue).width(100.dp).height(100.dp),
                contentAlignment= Alignment.TopStart) {
                Text(text = "Hello World", fontSize = 30.sp)

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview(modifier: Modifier = Modifier) {

        MyAppp()


}




