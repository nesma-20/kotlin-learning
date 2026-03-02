package com.example.compose_lec1.Tutorial.PostCard.HomeScreen


import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OutlineButton(
    onClick : ()-> Unit,
    caption : String,
    modifier: Modifier = Modifier,
    backgroundColor :Color = Color.Yellow,
    shape : Shape = RoundedCornerShape(16.dp),
    outlineColor :Color = Color.Gray ,
    contentColor: Color = Color.White
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(backgroundColor)
            .border(width = 1.dp, color = outlineColor, shape = shape)
            .clickable { onClick() }
            .padding(16.dp)
    ){
        BasicText(
            text = caption,
            modifier = Modifier.align(Alignment.Center),
            style = androidx.compose.ui.text.TextStyle(color = contentColor)
        )
    }
}
@Preview
@Composable
fun OutlineButtonPreview(modifier: Modifier = Modifier) {
    Box(Modifier.background(Color.White))
}