package com.example.compose_lec1.Tutorial.PostCard.HomeScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose_lec1.Tutorial.PostCard.story.StoryCircle
import com.example.compose_lec1.Tutorial.PostCard.story.stories


class  HomeScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            HomeScreenContent()
        }

    }}



@Composable
fun StorySection() {
    LazyRow(
        modifier = Modifier.fillMaxWidth().width(200.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ){
        items(stories){ story ->
            StoryCircle(
                profilePicture = painterResource(story.profilePicture),
                isSeen = story.isSeen ,
                onClick = {}
            )

        }
    }
}


@Composable
fun HomeScreenContent() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4)),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item {
            StorySection()
        }


item {
    OutlineButton(
        onClick = {},
        caption = "Create New Post",
        modifier = Modifier.padding(vertical = 8.dp)
    )
}
        items(feed){
            post ->
            PostCard(
                postImage = painterResource(post.postPicture),
                profileImage = painterResource(post.publisherProfilePicture),
                publisherName = post.publisherName,
                publishDate = post.publishData,
                contentText = post.postContent
            )
        }




    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenContent()
}