package com.jets.moviekmpproject.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver


actual class DatabaseDriverFactory(
    private val context:Context
) {
    actual fun createDriver(): SqlDriver =
AndroidSqliteDriver(
            schema = ArticlesDatabase.Schema,
            context = context,
            name = "ArticlesDatabase.database.db"
        )
}