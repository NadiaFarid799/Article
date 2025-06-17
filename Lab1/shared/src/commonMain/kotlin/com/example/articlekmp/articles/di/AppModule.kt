package com.jets.moviekmpproject.articles.di

import com.example.articlekmp.articles.ArticleLocalDataSource
import com.example.articlekmp.articles.ArticleRepository
import com.example.articlekmp.articles.ArticlesService
import com.jets.mad45_kmp.articles.ArticleViewModel

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}

val articleModule = module {
    single { ArticlesService(get()) }
    single { ArticleLocalDataSource(get()) }
    single { ArticleRepository(get(), get()) }
    single { ArticleViewModel(get()) }
}

val sharedKoinModule = listOf(
    networkModule,
    articleModule
)

