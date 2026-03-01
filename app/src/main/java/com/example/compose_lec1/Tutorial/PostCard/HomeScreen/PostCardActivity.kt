package com.example.compose_lec1.Tutorial.PostCard.HomeScreen
import androidx.compose.material3.Card
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_lec1.R
import com.example.compose_lec1.Tutorial.style2.myStyle


class PostCard : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            PostCard(
                postImage = painterResource(R.drawable.download),
                profileImage = painterResource(R.drawable.img),
                publisherName = "Nesma Dev",
                publishDate = " 2Jun 2026 , 3:12 PM",
                contentText = "test test test test test test  "
            )

        }
    }
}





@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    postImage: Painter,
    profileImage: Painter,
    publisherName: String,
    publishDate: String,
    contentText: String
) {

    Card(
        modifier = modifier

    ) {
        PostHeader(
            profileImage = profileImage,
            publisherName = publisherName,
            publishDate = publishDate
        )

        BasicText(
            text = contentText,
            style = myStyle, //
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp)
        )

        Image(
            painter = postImage,
            contentDescription = "post content",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
@Composable
fun PostCardPreview() {
    Column() {

            PostCard(
                postImage = painterResource(R.drawable.download),
                profileImage = painterResource(R.drawable.img),
                publisherName = "Nesma Dev",
                publishDate = " 2Jun 2026 , 3:12 PM",
                contentText = "test test test test test test  "
            )

    }
}

@Composable
fun Avatar(image: Painter) {
    Image(
        painter = image,
        contentDescription = "Profile Picture",
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(12.dp))
    )
}

