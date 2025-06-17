package com.example.articlekmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope


actual open class ParentViewModel : ViewModel() {
    actual val scope = viewModelScope
}