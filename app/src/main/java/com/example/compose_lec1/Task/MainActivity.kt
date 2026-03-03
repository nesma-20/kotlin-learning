package com.example.compose_lec1.Task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_lec1.New.style.myStyle
import com.example.compose_lec1.R
import com.example.compose_lec1.Tutorial.PostCard.HomeScreen.OutlineButton

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "start") {
                // (Welcome)
                composable("start") {
                    startScreen(onLoginClick = { navController.navigate("cart") })
                }
                composable("cart") {
                    CardScreen(navController = navController)
                }
                composable("profile") {
                    AccountScreen(onBackClick = { navController.popBackStack() } ,
                        navController = navController ) }
            }

        }
    }


    @Composable
    fun startScreen(onLoginClick: () -> Unit) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.task_image1),
                contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,

                )

            Column(
                modifier = Modifier.align(Alignment.BottomCenter)
                    .padding(bottom = 30.dp, start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                BasicText(
                    text = buildAnnotatedString {
                        append("أهلا بكم في نادي : ")
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFF4CAF50),
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp
                            )
                        ) {

                            withStyle(style = SpanStyle(color = Color(0xFFE2C488))) {
                                append(" ناز")
                            }

                        }
                    },
                    style = myStyle.copy(color = Color.White, fontSize = 24.sp)
                )

                Spacer(modifier = Modifier.height(10.dp))
                BasicText(
                    text = "اكتشف معنا المفهوم الصحيح للتدريب \n" +
                            "التدريب مخصص من أجلك",
                    style = myStyle.copy(color = Color.White, fontSize = 24.sp)
                )
                Spacer(modifier = Modifier.padding(bottom = 31.dp))
                OutlineButton(
                    onClick = onLoginClick,
                    caption = "تسجيل دخول",
                    contentColor = Color.White

                )
                Spacer(modifier = Modifier.padding(bottom = 139.dp))

            }


        }
    }




    @Preview
    @Composable
    fun startScreenPreview() {
        startScreen(onLoginClick = {})
    }

}