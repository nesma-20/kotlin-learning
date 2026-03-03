package com.example.compose_lec1.Task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose_lec1.R
import com.example.compose_lec1.Task.compo.DecoratedTextFiled
import com.example.compose_lec1.Task.compo.MyBottomNavigationBar

@Composable
fun AccountScreen(onBackClick: () -> Unit, navController: NavController) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(painterResource(R.drawable.back), contentDescription = null)
                }
//                Text(
//                    "Account Information",
//                    modifier = Modifier.align(Alignment.Center),
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.SemiBold
//                )
            }
        },
        bottomBar = { MyBottomNavigationBar(navController = navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))


            Text(
                "Account Information",
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            DecoratedTextFiled(label = "Name", initialValue = "nesma")
            DecoratedTextFiled(label = "Email", initialValue = "nesma@email.Com")
            DecoratedTextFiled(label = "Phone", initialValue = "00000000000")

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9F06))
            ) {
                Text("Save Changes", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    val navController = androidx.navigation.compose.rememberNavController()
    AccountScreen(
        onBackClick = {  },
        navController = navController
    )
}