package com.example.compose_lec1.Task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.compose_lec1.Task.compo.BottomNavigationBar
import com.example.compose_lec1.Task.compo.CartHeader
import com.example.compose_lec1.Task.compo.MyBottomNavigationBar
import com.example.compose_lec1.Tutorial.PostCard.HomeScreen.OutlineButton

class EmptyCarActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            CardScreen(navController = rememberNavController())
        }

    }
}
@Composable
fun CardScreen(navController: androidx.navigation.NavController) {
    Scaffold(
        topBar = { CartHeader() },
        bottomBar = { MyBottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.shop_img),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = "لم تقم بإضافة أي منتج إلى السلة مؤخراً",
                modifier = Modifier.padding(20.dp),
                color = Color.Gray
            )
            Spacer(Modifier.padding(bottom = 46.dp))
            OutlineButton(
                onClick = {},
                caption = "اذهب للتسوق الآن",
                backgroundColor = Color(0xFF9E8069),
                contentColor = Color.White
            )
        }
    }
}




@Preview
@Composable
fun CardScreenPreview() {
    CardScreen(navController = rememberNavController())
}