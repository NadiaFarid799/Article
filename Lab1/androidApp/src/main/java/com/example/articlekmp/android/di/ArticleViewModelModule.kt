package com.jets.moviekmpproject.android.di

import com.jets.mad45_kmp.articles.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ArticleViewModel(get()) }
}