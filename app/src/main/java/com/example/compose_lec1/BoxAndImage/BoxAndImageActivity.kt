package com.example.compose_lec1.BoxAndImage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_lec1.R
import com.example.compose_lec1.ui.theme.Compose_lec1Theme

class BoxAndImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()

        setContent {
val title  = "nesma"
            val  content  = "nesma ff"
            val painter = painterResource(id = R.drawable.download)
            Box(
                modifier = Modifier.width(200.dp).padding(16.dp).statusBarsPadding()
            ){
                ImageCard(title = title , content = content , painter = painter)
            }




        }



    }

    @Composable
    fun ImageCard(title : String  , content : String, painter: Painter){
        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
        , elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
            pressedElevation = 8.dp,
            focusedElevation = 6.dp
        )
        ){
            Box(
                modifier = Modifier.height(200.dp)
            ){
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painter,
                    contentScale = ContentScale.Crop ,
                    contentDescription =  content
                    )

                Box(modifier = Modifier.fillMaxSize().background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 200f
                    )
                ),
                    contentAlignment = Alignment.BottomStart

                    ){
Text(title, modifier = Modifier.padding(16.dp) ,style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
    }

    @Preview(showBackground = true)
@Composable
fun Greeting(name :String = "" , modifier: Modifier = Modifier) {
   Text("Hello $name",modifier = modifier)

}
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview(){


    }
}