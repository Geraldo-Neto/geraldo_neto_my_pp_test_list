package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MyListAppViewModel: ViewModel() {
    private val _state = MutableStateFlow<State>(State())

    data class State(val myList: List<MyItem> = emptyList())
}