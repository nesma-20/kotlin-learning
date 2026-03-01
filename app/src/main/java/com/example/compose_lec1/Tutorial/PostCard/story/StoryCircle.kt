package com.example.compose_lec1.Tutorial.PostCard.story

import android.graphics.Picture
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose_lec1.R


@Composable
fun StoryCircle(modifier: Modifier = Modifier,
                isSeen : Boolean ,
                onClick :() -> Unit ,
                profilePicture: Painter ,


                ) {


    val borderColor = if (isSeen) Color.Transparent else Color.Blue
    Box(
        modifier = modifier
            .size(92.dp)
            .clip(CircleShape)
            .border(
                width = 3.dp,
                shape = CircleShape,
                color = borderColor
            )
            .padding(4.dp)
    ){
        Image(painter = profilePicture, contentDescription = "profile"

            , modifier = Modifier
                .clip(CircleShape).fillMaxSize()
                .clickable { onClick() },
            contentScale = ContentScale.FillBounds

        )
    }




}

@Composable
fun StoryCircleSeenPreview(modifier: Modifier = Modifier) {
    StoryCircle(
        profilePicture = painterResource(R.drawable.img_2) ,
        isSeen = true ,
        onClick = {}
    )
}