package com.example.compose_lec1.Tutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_lec1.R




@Composable
fun FirstImage() {
    Image(
        painter = painterResource(R.drawable.download)
   ,
        contentDescription = stringResource(R.string.developer_image_description)
, modifier = Modifier.size(200.dp).background(Color.Gray)
    )
}

@Preview
@Composable
fun FirstImagePerview() {
    FirstImage()
}