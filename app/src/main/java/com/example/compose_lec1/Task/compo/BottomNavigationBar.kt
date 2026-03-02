package com.example.compose_lec1.Task.compo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.compose_lec1.R
import com.example.compose_lec1.Tutorial.PostCard.HomeScreen.OutlineButton






class BottomNavigationBar : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MyBottomNavigationBar(navController = rememberNavController())
        }

    }
}
object Routes {
    const val START = "start"
    const val CART = "cart"
    const val PROFILE = "profile"
}
@Composable
fun MyBottomNavigationBar(navController: androidx.navigation.NavController) {

    Column{
        androidx.compose.material3.HorizontalDivider(
            thickness = 0.5.dp,
            color = Color.LightGray.copy(alpha = 0.5f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(painter = painterResource(R.drawable.account), contentDescription = null, modifier = Modifier.size(24.dp).clickable{
                navController.navigate("profile") {
                    launchSingleTop = true
                }
            })

            Image(painter = painterResource(R.drawable.outline_favorite_24), contentDescription = null, modifier = Modifier.size(24.dp))
            Image(painter = painterResource(R.drawable.outline_add_card_24), contentDescription = null, modifier = Modifier.size(24.dp).size(24.dp)
                .clickable {
                    navController.navigate("cart"){
                        launchSingleTop = true
                    }
                })
            Image(painter = painterResource(R.drawable.baseline_add_home_24), contentDescription = null, modifier = Modifier.size(24.dp)
                .size(24.dp)
                .clickable {
                    navController.navigate("profile"){
                        popUpTo("start") { inclusive = true }
                    }
                })
        }
    }


}

@Preview
@Composable
fun BottomNavPreview() {
   // MyBottomNavigationBar()
}