package com.example.compose_lec1.New

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_lec1.New.style.myStyle
import com.example.compose_lec1.R


@Composable
fun FirstFoundationCompose(modifier: Modifier = Modifier) {
//    BasicText("Hello world \n",
//        maxLines = 2
//        )

//foundation with custom font family style
//    var textValue : String by remember {
//        mutableStateOf("hello")
//    }
//    TextField(
//        value = textValue,
//        onValueChange = {
//     newText -> textValue = newText
//        },
//        textStyle = myStyle,
//    )


//    BasicText(
//        text = "something",
//        style = myStyle
//    )

    // Annotated String


//    BasicText(
//        text = buildAnnotatedString {
//            withStyle(
//                SpanStyle(color = Color.Blue)
//            ){
//                append("@Nesma")
//            }
//
//            withStyle(
//                SpanStyle(color = Color.Black)
//            ){
//                append("Good Morning")
//            }
//
//
//        }
//    )


    //عند كل عمليه الضغط الزر راح يكبر اكتر

var scaleFactor : Float by remember { mutableFloatStateOf(1f) }
    // Modifier
    BasicText(
        text = "Modifier me",
        style = myStyle,
        modifier = Modifier
            .scale(scaleFactor)
            .clip(RoundedCornerShape(16.dp))
            .blueLight()
            .background(Color.Cyan)
            .clickable {
            scaleFactor += 0.2f
            }
            .border(
                width = 2.dp, color = Color.Red,
                shape = RoundedCornerShape(16.dp)
            )

//            .height(60.dp)
//            .width(150.dp)
//            .padding(
//                start = 16.dp ,
//                top = 40.dp ,
//                bottom = 30.dp ,
//
//            )
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp

            )
    )


// Text visual transformation
//var textValue1 : String by remember { mutableStateOf("hello") }
//    BasicTextField(
//        value = textValue1,
//        onValueChange = {
//            newText1 -> textValue1 = newText1
//
//        },
//          visualTransformation = EvenOdd(),
//
//        // keyboard custom
//        keyboardOptions = KeyboardOptions(
//            capitalization = KeyboardCapitalization.Characters,
//            keyboardType = KeyboardType.Password,
//        )
//    )


}



// custom modifier
@Stable
fun  Modifier.blueLight(): Modifier {
    return  this.then(Modifier.shadow(
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        spotColor = Color.Blue
    ))
}




@Preview
@Composable
fun Preview(modifier: Modifier = Modifier) {
    FirstFoundationCompose()
}

//custom visualTransformation


class EvenOdd : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            text = buildAnnotatedString {
                text.forEachIndexed { index, character ->
                    if (index % 2 == 0) {
                        append(character.uppercase())
                    } else {
                        append(character.lowercase())
                    }
                }
            },
            offsetMapping = OffsetMapping.Identity
        )
    }

}