package com.example.articlekmp.articles

import ArticlesDatabase


class ArticleLocalDataSource(
    private val database: ArticlesDatabase
) {
    fun getAllArticles(): List<ArticleRaw> {
        return database.articleDatabaseQueries.selectAllArticles(::mapToArticle).executeAsList()
    }

    fun insertAllArticles(articles: List<ArticleRaw>) {
        database.articleDatabaseQueries.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }
    }

    private fun insertArticle(article: ArticleRaw) {
        database.articleDatabaseQueries.insertArticle(
            article.name ?: "",
            article.desc,
            article.date ?: "",
            article.imgUrl
        )
    }

    private fun mapToArticle(
        title: String?,
        desc: String?,
        date: String?,
        imgUrl: String?
    ): ArticleRaw {
        return ArticleRaw(
            title ?: "",
            desc ?: "",
            date ?: "",
            imgUrl ?: ""
        )
    }
}