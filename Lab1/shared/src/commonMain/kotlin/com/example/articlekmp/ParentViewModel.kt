package com.example.articlekmp

import kotlinx.coroutines.CoroutineScope


expect open class ParentViewModel() {
    val scope: CoroutineScope
}