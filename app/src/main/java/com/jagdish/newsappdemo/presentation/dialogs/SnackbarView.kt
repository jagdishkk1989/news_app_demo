package com.jagdish.newsappdemo.presentation.dialogs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun SnackBarView(
    message: String,
    snackbarHostState: SnackbarHostState
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val snackbar = createRef()
        SnackbarHost(modifier = Modifier.constrainAs(snackbar) {
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }, hostState = snackbarHostState, snackbar = {
            Snackbar {
                Text(text = message)
            }
        })

    }
}