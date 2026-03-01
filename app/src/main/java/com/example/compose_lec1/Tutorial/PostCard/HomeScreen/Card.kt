package com.example.compose_lec1.Tutorial.PostCard.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Card(
    modifier: Modifier = Modifier,

    content:@Composable ()-> Unit


) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp) //
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
            .border(width = 1.dp,
                color = Color.Black.copy(alpha = 0.08f),
                shape = RoundedCornerShape(24.dp)
                )
    ) {
        content()
    }
}