package db.shared

import ArticlesDatabase
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.AfterVersion
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import sqldelight.articles.db.ArticleDatabaseQueries
import kotlin.Long
import kotlin.Unit


internal val schema: SqlSchema<QueryResult.Value<Unit>>
  get() = ArticlesDatabaseImpl.Schema

internal fun newInstance(driver: SqlDriver): ArticlesDatabase =
    ArticlesDatabaseImpl(driver)

private class ArticlesDatabaseImpl(
  driver: SqlDriver,
) : TransacterImpl(driver), ArticlesDatabase {
  override val articleDatabaseQueries: ArticleDatabaseQueries = ArticleDatabaseQueries(driver)

  public object Schema : SqlSchema<QueryResult.Value<Unit>> {
    override val version: Long
      get() = 1

    override fun create(driver: SqlDriver): QueryResult.Value<Unit> {
      driver.execute(null, """
          |CREATE TABLE Article (
          |     title TEXT NOT NULL,
          |     desc TEXT,
          |     date TEXT NOT NULL,
          |     imgUrl TEXT
          |)
          """.trimMargin(), 0)
      return QueryResult.Unit
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Long,
      newVersion: Long,
      vararg callbacks: AfterVersion,
    ): QueryResult.Value<Unit> = QueryResult.Unit
  }
}
