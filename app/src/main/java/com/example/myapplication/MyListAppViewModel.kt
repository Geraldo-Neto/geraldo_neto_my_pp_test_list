package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
//didnt use, because of time, but would have this as mvvm, using states and events
class MyListAppViewModel: ViewModel() {
    private val _state = MutableStateFlow<State>(State())

    data class State(val myList: List<MyItem> = emptyList())
}