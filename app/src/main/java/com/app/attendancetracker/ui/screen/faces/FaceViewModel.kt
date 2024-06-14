package com.app.attendancetracker.ui.screen.faces

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.app.attendancetracker.data.Repository
import com.app.attendancetracker.data.model.AppState
import com.app.attendancetracker.data.model.FaceInfo
import com.app.attendancetracker.lib.LOG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FaceViewModel @Inject constructor(private val repo: Repository) : ViewModel() {
    lateinit var homeHost: NavHostController
    lateinit var appState: AppState
    val faces: Flow<List<FaceInfo>> = repo.faces

    fun onCompose(state: AppState, home: NavHostController) = viewModelScope.launch(Dispatchers.IO) {
        runCatching {
            appState = state
            homeHost = home
            LOG.d("Add Face Screen Composed")
        }.onFailure { LOG.e(it, it.message) }
    }

    fun onDispose() = runCatching {
        LOG.d("Add Face Screen Disposed")
    }.onFailure { LOG.e(it, it.message) }

    fun onDeleteFace(face: FaceInfo) = viewModelScope.launch(Dispatchers.IO) {
        runCatching {
            repo.deleteFace(face).getOrNull()
            LOG.d("Deleted Face \t:\t$face")
        }.onFailure { LOG.e(it, it.message) }
    }
}
