package com.app.attendancetracker.ui.screen.welcome

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.app.attendancetracker.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(private val repo: Repository) : ViewModel() {
    var pageCount: MutableState<Int> = mutableStateOf(3)
}
