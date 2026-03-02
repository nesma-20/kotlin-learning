package com.example.compose_lec1.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_lec1.Task.CardScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            BasicScreen()
        }

    }
}

val largeStyle = TextStyle(fontSize = 32.sp)


//state hoisting

@Composable
fun BasicScreen(modifier: Modifier = Modifier) {
    var numberValue: Int by remember { mutableIntStateOf(5) }
    StateScreen(
        numberValue = numberValue,
        onIncrease = { numberValue++ },
        onDecrease = { numberValue-- })
}

@Composable
fun StateScreen(
    numberValue: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicText(
            text = numberValue.toString(),
            style = largeStyle
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {

            BasicText(
                text = "-",
                style = largeStyle,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .clickable {
                        onDecrease()
                    }


            )

            BasicText(
                text = "+",
                style = largeStyle,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .clickable {
                        onIncrease()
                    }
            )
        }
    }
}


@Preview
@Composable
fun StateScreenPreview() {
    BasicScreen()
}