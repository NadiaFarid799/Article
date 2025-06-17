package com.jets.moviekmpproject.android.di

import ArticlesDatabase
import app.cash.sqldelight.db.SqlDriver
import com.jets.moviekmpproject.database.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<ArticlesDatabase> { ArticlesDatabase(get()) }
}