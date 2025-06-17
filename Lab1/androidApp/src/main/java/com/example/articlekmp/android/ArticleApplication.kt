package com.example.articlekmp.android

import android.app.Application
import com.jets.moviekmpproject.android.di.databaseModule
import com.jets.moviekmpproject.android.di.viewModelModule
import com.jets.moviekmpproject.articles.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArticleApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        val allModules = sharedKoinModule + viewModelModule + databaseModule
        startKoin {
            androidContext(this@ArticleApplication)
            modules(allModules)
        }
    }
}