package com.example.compose_lec1.Tutorial.PostCard.story

import com.example.compose_lec1.R

data class Story(
    val profilePicture : Int ,
    val isSeen : Boolean
)




val stories = listOf(
    Story(
        profilePicture = R.drawable.img_1,
        isSeen =  false
    ),
    Story(
        profilePicture = R.drawable.img_5 ,
        isSeen =  true
    ),
    Story(
        profilePicture = R.drawable.img ,
        isSeen =  false
    ),
    Story(
        profilePicture = R.drawable.img_3 ,
        isSeen =  true
    ),
    Story(
        profilePicture = R.drawable.img_1 ,
        isSeen =  false
    ),    Story(
        profilePicture = R.drawable.img_4 ,
        isSeen =  false
    ),
    Story(
        profilePicture = R.drawable.img_5 ,
        isSeen =  true
    ),
    Story(
        profilePicture = R.drawable.img ,
        isSeen =  false
    ),
    Story(
        profilePicture = R.drawable.img_3 ,
        isSeen =  true
    ),
    Story(
        profilePicture = R.drawable.img_1 ,
        isSeen =  false
    )

)