package com.example.compose_lec1.Tutorial.PostCard.HomeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_lec1.R


@Composable
fun PostHeader(
    
    modifier: Modifier = Modifier,
    profileImage : Painter,
    publisherName : String,
    publishDate : String,
               
    ) {
    Row(
        modifier = modifier.fillMaxWidth().padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Avatar(profileImage)
        Column() {
            BasicText(
                text = publisherName
            )

            BasicText(
                text = publishDate
            )
        }
    }
}


@Preview
@Composable
fun PostHeaderPreview(modifier: Modifier = Modifier) {
    PostHeader(
        profileImage = painterResource(R.drawable.img),
        publisherName = "Dev Nesma",
        publishDate = " 2Jun 2026 , 3:12 PM"
    )
}