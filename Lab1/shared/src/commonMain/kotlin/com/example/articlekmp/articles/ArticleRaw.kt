package com.example.articlekmp.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    @SerialName("title")
    val name: String?,
    @SerialName("description")
    val desc: String?,
    @SerialName("publishedAt")
    val date: String?,
    @SerialName("urlToImage")
    val imgUrl: String?
)
