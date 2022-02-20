package com.example.invitationlistplanner.ui.allguestsscreen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.invitationlistplanner.R
import com.example.invitationlistplanner.ui.theme.InvitationListPlannerTheme
import com.example.invitationlistplanner.util.UiEvent
import kotlinx.coroutines.flow.collect
import org.koin.androidx.compose.getViewModel

@Composable
fun AllGuestsScreen(
    onNavigate: ((UiEvent.Navigate) -> Unit)?,
    context: Context,
    viewModel: AllGuestsViewModel = getViewModel()
) {
    val guests = viewModel.guests.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect() { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    val result = scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                    if (result == SnackbarResult.ActionPerformed) {
                        viewModel.onEvent(AllGuestsScreenEvent.OnUndoClick)
                    }
                }
                is UiEvent.Navigate -> onNavigate?.let { it(event) }
                else -> Unit
            }
        }
    }
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addGuest() }) {
                Icon(Icons.Default.Add, "Add")
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {
                Text(
                    modifier = Modifier.padding(20.dp),
                    text = context.getString(R.string.number_of_guests),
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 6.dp),
                    text = guests.value.size.toString(),
                    color = Color.White
                )
            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(guests.value) { guest ->
                    GuestItem(guest = guest, onEvent = viewModel::onEvent)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuestScreenPreview() {
    InvitationListPlannerTheme {
        AllGuestsScreen(null, LocalContext.current)
    }
}
