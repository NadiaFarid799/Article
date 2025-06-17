package sqldelight.articles.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.String

public class ArticleDatabaseQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectAllArticles(mapper: (
    title: String,
    desc: String?,
    date: String,
    imgUrl: String?,
  ) -> T): Query<T> = Query(-655_594_027, arrayOf("Article"), driver, "ArticleDatabase.sq",
      "selectAllArticles", "SELECT Article.* FROM  Article") { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1),
      cursor.getString(2)!!,
      cursor.getString(3)
    )
  }

  public fun selectAllArticles(): Query<Article> = selectAllArticles { title, desc, date, imgUrl ->
    Article(
      title,
      desc,
      date,
      imgUrl
    )
  }

  public fun insertArticle(
    title: String,
    desc: String?,
    date: String,
    imgUrl: String?,
  ) {
    driver.execute(-1_173_703_952, """
        |INSERT INTO Article(title, desc, date, imgUrl)
        |VALUES(?,?, ?, ?)
        """.trimMargin(), 4) {
          bindString(0, title)
          bindString(1, desc)
          bindString(2, date)
          bindString(3, imgUrl)
        }
    notifyQueries(-1_173_703_952) { emit ->
      emit("Article")
    }
  }

  public fun removAllArticles() {
    driver.execute(-110_487_446, """DELETE FROM Article""", 0)
    notifyQueries(-110_487_446) { emit ->
      emit("Article")
    }
  }
}
