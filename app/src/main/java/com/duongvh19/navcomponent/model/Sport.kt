package com.duongvh19.navcomponent.model


import com.duongvh19.navcomponent.R
import java.io.Serializable

data class Sport(
    val id: Int,
    val titleResourceId: Int,
    val subTitleResourceId: Int,
    val imageResourceId: Int,
    val sportsImageBanner: Int,
    val newsDetails: Int = R.string.sports_news_detail_text
) : Serializable