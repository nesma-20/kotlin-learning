package com.example.compose_lec1.BottomNavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.compose_lec1.box.MyAppp

class BottomNavigationScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyBottomNavigation()

        }



    }}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyBottomNavigation(modifier: Modifier = Modifier) {


    var bottomState by remember {
        mutableStateOf("Home")
    }
    Scaffold(

        content = {  innerPadding ->
            Box(modifier = Modifier.fillMaxSize().padding(innerPadding)
                , Alignment.Center,

                ){
                Text(text =  bottomState,
                    fontSize = 25.sp ,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        bottomBar = {

            NavigationBar(containerColor = Color.White) {

                NavigationBarItem(
                    selected = bottomState == "Home",
                    onClick = {  bottomState = "Home" },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Home") }
                )


                NavigationBarItem(
                    selected = bottomState == "Account",
                    onClick = {  bottomState = "Account" },
                    icon = { Icon(Icons.Default.AccountBox, contentDescription = null) },
                    label = { Text("Account") }
                )


                NavigationBarItem(
                    selected = bottomState == "Search",
                    onClick = {  bottomState = "Search" },
                    icon = { Icon(Icons.Default.Search, contentDescription = null) },
                    label = { Text("Search") }
                )
            }
        }
    )
}




@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview(modifier: Modifier = Modifier) {

    MyBottomNavigation()


}