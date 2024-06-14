package com.app.attendancetracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.app.attendancetracker.data.model.AppState
import com.app.attendancetracker.ui.screen.addFace.AddFaceScreen
import com.app.attendancetracker.ui.screen.faces.FacesScreen
import com.app.attendancetracker.ui.screen.recogniseFace.RecogniseFaceScreen

@Composable
fun HomeHost(
    state: AppState,
    startDestination: String,
    modifier: Modifier = Modifier,
    route: String? = null,
    host: NavHostController = rememberNavController(),
    builder: NavGraphBuilder.() -> Unit = homeNavGraphBuilder(state, host),
) = NavHost(host, startDestination, modifier, route, builder)

fun homeNavGraphBuilder(state: AppState, host: NavHostController): NavGraphBuilder.() -> Unit = {
    Routes.Faces(this) { FacesScreen(state, host) }
    Routes.AddFace(this) { AddFaceScreen(state, host) }
    Routes.Recognise(this) { RecogniseFaceScreen(state, host) }
}

