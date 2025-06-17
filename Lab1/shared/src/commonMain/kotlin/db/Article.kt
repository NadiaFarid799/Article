package sqldelight.articles.db

import kotlin.String

public data class Article(
  public val title: String,
  public val desc: String?,
  public val date: String,
  public val imgUrl: String?,
)
