package com.example.compose_lec1.Tutorial.style2

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.compose_lec1.R


private val shareTech = FontFamily(
    Font(R.font.share, FontWeight.Normal),

)
val myStyle = TextStyle(
    color = Color.Black,
    fontStyle = FontStyle.Italic,
    fontSize = 18.sp,
  fontFamily = shareTech
    )