package com.example.compose_lec1.Task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_lec1.Task.compo.SearchDecoratedTextField
import com.example.compose_lec1.Tutorial.PostCard.HomeScreen.Card
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toDrawable
import com.example.compose_lec1.R
import com.example.compose_lec1.Tutorial.PostCard.HomeScreen.feed

class SearchScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {


            FirstComposable()


        }

    }
}

@Composable
fun FirstComposable(

) {


Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF9F9F9))) {

   Column(
       modifier = Modifier
           .padding(horizontal = 15.dp)
           .padding(top = 60.dp),
       horizontalAlignment = Alignment.CenterHorizontally
   ) {

       Text("نتائج البحث ",fontSize = 18.sp,
           fontWeight = FontWeight.Bold,
           modifier = Modifier.padding(bottom = 15.dp))
       Spacer(modifier = Modifier.padding(bottom = 5.dp))
       SearchDecoratedTextField(
           label = "Search...",
           onCancelClick = { }
       )
       Spacer(modifier = Modifier.padding(bottom = 10.dp))
       Text(
           text = "نتائج مشابهة",
           modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
           textAlign = TextAlign.End,
           fontSize = 14.sp,
           color = Color.Black
       )
       HorizontalDivider(
           modifier = Modifier.fillMaxWidth(),
           thickness = 1.dp,
           color = Color.LightGray
       )

       LazyVerticalGrid(
           columns = GridCells.Fixed(2),
           contentPadding = PaddingValues(12.dp),
           horizontalArrangement = Arrangement.spacedBy(8.dp),
           verticalArrangement = Arrangement.spacedBy(8.dp),
           modifier = Modifier.fillMaxSize().weight(1f)
       ) {
           items(feed) { post ->
               CarCard(
                   image = painterResource(R.drawable.car_image),
                   title = "توسان اكسنت 2022", // مثال
                   status = "ممتاز",
                   price = "500000",
                   location = "أبو ظبي"
               )
           }
       }
   }
}


}

@Composable
fun CarCard(
    image: Painter,
    title: String,
    status: String,
    price: String,
    location: String
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth().height(120.dp)) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(30.dp),
                    shadowElevation = 2.dp
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_favorite_24),
                        contentDescription = null,
                        modifier = Modifier.padding(6.dp),
                        tint = Color.Gray
                    )
                }
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomEnd) // يمين تحت
                        .padding(8.dp),
                    shadowElevation = 1.dp
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = location,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            painter = painterResource(R.drawable.location),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp),
                            tint = Color.Red
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.End
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = status,
                        fontSize = 12.sp,
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = " : الحالة",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "درهم ",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = price,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    FirstComposable()
}