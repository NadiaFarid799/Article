package com.example.articlekmp.articles

class ArticleRepository(
    private val service: ArticlesService,
    private val database: ArticleLocalDataSource
) {

    suspend fun getArticles(): List<ArticleRaw> {
        val articlesDb = database.getAllArticles()
        println(" ${articlesDb.size} from DB ")
        if (articlesDb.isEmpty()){
            val fetchedArticle = service.fetchArticles()
            database.insertAllArticles(fetchedArticle)
            return fetchedArticle
        }
        return articlesDb
    }

}