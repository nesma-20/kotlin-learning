package com.example.compose_lec1.Tutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_lec1.Tutorial.style2.myStyle


// Box

//@Composable
//fun LearnLayout() {
//    Box(modifier = Modifier
//        .fillMaxSize()
//        .background(Color.White)) {
//      FirstComponent(Modifier)
//        SecondeComponent(modifier =  Modifier.align(Alignment.CenterStart))
//        ThirdComponent(modifier =  Modifier.align(Alignment.BottomEnd))
//
//    }
//}

// Row
//@Composable
//fun LearnLayout(modifier: Modifier = Modifier) {
//    Row(
//        modifier  =
//            Modifier.fillMaxSize()
//                .background(Color.White)
//
//
//        , verticalAlignment = Alignment.Top
//        , horizontalArrangement = Arrangement.SpaceAround
//    ){
//        FirstComponent(modifier)
//        SecondeComponent(modifier)
//        ThirdComponent(modifier)
//    }
//}


//Flow Row
//@Composable
//fun LearnLayout(modifier: Modifier = Modifier) {
//    FlowRow(
//        modifier  =
//            Modifier.fillMaxSize()
//                .background(Color.White),
//        horizontalArrangement = Arrangement.SpaceBetween
//   , verticalArrangement = Arrangement.Center
//
//   ){
//        for (i in 1 ..5 ){
//            FirstComponent(modifier)
//            SecondeComponent(modifier)
//            ThirdComponent(modifier)
//        }
//
//    }
//}



//Flow Column
@Composable
fun LearnLayout(modifier: Modifier = Modifier) {
    FlowColumn (
        modifier  =
            Modifier.fillMaxSize()
                .background(Color.White),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
        , verticalArrangement = Arrangement.spacedBy(20.dp)

    ){
        for (i in 1 ..7 ){
            FirstComponent(modifier)
            SecondeComponent(modifier)
            ThirdComponent(modifier)
        }

    }
}



// Column
//@Composable
//fun LearnLayout(modifier: Modifier = Modifier) {
//    Column (modifier  =
//        Modifier.fillMaxSize()
//            .background(Color.White),
//
//horizontalAlignment = Alignment.CenterHorizontally,
//       verticalArrangement =  Arrangement.spacedBy(20.dp)
//        ){
//        FirstComponent(modifier)
//       Spacer(Modifier.height(20.dp))
//        SecondeComponent(modifier)
//      Spacer(Modifier.height(20.dp))
//        ThirdComponent(modifier)
//    }
//}




@Composable
fun FirstComponent(
    modifier: Modifier = Modifier
){
    BasicText(
        text = "First Component"
        , style = myStyle,
        modifier = modifier

            .background(Color.Red)
            .padding(8.dp)
    )
}


@Composable
fun SecondeComponent(
    modifier: Modifier = Modifier
){
    BasicText(
        text = "Seconde "
        , style = myStyle,
        modifier = modifier

            .background(Color.Green)
            .padding(8.dp)
    )
}


@Composable
fun ThirdComponent(
    modifier: Modifier = Modifier
){
    BasicText(
        text = "Third Component"
        , style = myStyle,
        modifier = modifier
            .background(Color.Yellow)
            .padding(8.dp)
    )
}


@Preview
@Composable
fun Preview(modifier: Modifier = Modifier) {
    LearnLayout()
}