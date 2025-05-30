package com.example.vkapp.screens


import android.annotation.SuppressLint
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.FloatingActionButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.SnackbarDuration
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.SnackbarHost
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.SnackbarHostState
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.SnackbarResult
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import com.example.vkapp.ui.theme.NavigationItem
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "AutoboxingStateCreation")
@Composable
fun MainScreen (){
    val snackbarHostState = SnackbarHostState()
    val scope = rememberCoroutineScope()
    val fabIsVisible = remember { mutableStateOf(true) }

    Scaffold (
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            if (fabIsVisible.value) {
                FloatingActionButton(onClick = {
                    scope.launch {
                        val action = snackbarHostState.showSnackbar(
                            message = "This is snackbar",
                            actionLabel = "Hide FAB",
                            duration = SnackbarDuration.Long
                        )
                        if (action == SnackbarResult.ActionPerformed) {
                            fabIsVisible.value = false

                        }
                    }
                }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
            }
        },
        bottomBar = {
            BottomNavigation {
                val selectedPosition = remember {  mutableStateOf(value = 0)}

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                items.forEachIndexed {index, item ->
                    BottomNavigationItem(
                        selected = selectedPosition.value == index,
                        onClick = {selectedPosition.value = index},
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary

                    )
                }
            }
        }
    ) {

    }
}