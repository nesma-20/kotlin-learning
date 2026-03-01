package com.example.compose_lec1.List
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class listActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
 //enableEdgeToEdge()


        setContent{

            LazyColumn (

                modifier = Modifier.fillMaxSize()
            ) {

                item(listOf("A" ,"B" , "C")) {


                    for (i in 1 .. 50){
                        Text("Item  $i" , modifier = Modifier.padding(16.dp) )
                    }



                }
            }
        }
    }


}

/*
*   Column(

                modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
            ) {

                for (i in 1 .. 50){
                    Text("Item $i" , modifier = Modifier.padding(16.dp) )
                }
            }
* */