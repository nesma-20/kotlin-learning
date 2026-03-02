package com.example.compose_lec1.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text
import java.time.format.TextStyle








class StateFul: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

          
        }

    }}

//state hoisting
//stateful = hoisting
@Composable
fun DecoratedTextFiled() {
    var textcontent : String by remember { mutableStateOf("") }
        StateLesDecoratedTextFiled(
            text =  textcontent ,
            UpdateText =  { textcontent = it},


        )
}


// statles
@Composable
fun StateLesDecoratedTextFiled(
    modifier: Modifier = Modifier,
     UpdateText : (String) -> Unit ,
    text: String

                               ) {


    BasicTextField(
        value = text ,
        onValueChange = UpdateText,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(16.dp, vertical = 8.dp)
    )

    }








//  Stateful and Stateless components
//@Composable
//fun DecoratedTextFiled(modifier: Modifier = Modifier) {
//    var textcontent : String by remember { mutableStateOf("")
//
//    }
//
//
//    BasicTextField(
//        value = textcontent ,
//        onValueChange = {
//            textcontent =  it
//        },
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth()
//            .clip(RoundedCornerShape(8.dp))
//            .background(Color.White)
//            .padding(16.dp, vertical = 8.dp)
//    )
//}


@Composable
fun ColorfulText(modifier: Modifier = Modifier,text: String) {
    BasicText(
        text = text ,
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 44.sp ,
            color = Color.Red
        )
    )
}
@Preview
@Composable
fun DecoratedTextFiledPreview(modifier: Modifier = Modifier) {
    Column(Modifier
        .fillMaxSize()
        .background(Color.White)){
        DecoratedTextFiled()
        ColorfulText(text = "Hello")
    }
}