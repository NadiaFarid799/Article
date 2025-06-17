package com.jets.mad45_kmp.articles

import com.example.articlekmp.articles.ArticleRaw

data class ResponseState (
    val successState: List<ArticleRaw> = listOf(),
    val loadingState: Boolean = false,
    val failureState: String? = null
)