

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import db.shared.newInstance
import db.shared.schema
import sqldelight.articles.db.ArticleDatabaseQueries

import kotlin.Unit


interface ArticlesDatabase : Transacter {
  val articleDatabaseQueries: ArticleDatabaseQueries

   companion object {
      val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = schema

     operator fun invoke(driver: SqlDriver): ArticlesDatabase =
         newInstance(driver)
  }
}
