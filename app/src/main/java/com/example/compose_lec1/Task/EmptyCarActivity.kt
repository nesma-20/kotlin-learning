package com.example.compose_lec1.Task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.compose_lec1.R
import com.example.compose_lec1.Task.compo.CartHeader
import com.example.compose_lec1.Tutorial.PostCard.HomeScreen.OutlineButton

class EmptyCarActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            CardScreen()
        }

    }
}

@Composable
fun CardScreen() {
    Column(


                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(10.dp)
    ) {


        CartHeader()

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(20.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Image(
                painter = painterResource(R.drawable.shop_img),
                contentDescription = "Empty Basket",
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Fit,

                )


            Text(
                text = "لم تقم بإضافة أي منتج إلى السلة مؤخراً",
                color = Color.Gray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center ,
                modifier = Modifier.padding(top = 20.dp, bottom = 40.dp)

            )


            OutlineButton(
                onClick = {},
                caption = "اذهب للتسوق الآن",
                backgroundColor = Color(0xFF9E8069),
                contentColor = Color.White,
                outlineColor = Color.Transparent
            )
        }

    }
}

@Preview
@Composable
fun CardScreenPreview() {
    CardScreen()
}