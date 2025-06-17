package com.example.articlekmp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

actual open class ParentViewModel {
    actual val scope = CoroutineScope(Dispatchers.Main)
}