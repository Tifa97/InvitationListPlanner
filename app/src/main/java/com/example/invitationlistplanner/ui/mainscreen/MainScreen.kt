package com.example.invitationlistplanner.ui.mainscreen

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.invitationlistplanner.R
import com.example.invitationlistplanner.ui.theme.InvitationListPlannerTheme
import com.example.invitationlistplanner.util.UiEvent
import kotlinx.coroutines.flow.collect
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(
    onNavigate: ((UiEvent.Navigate) -> Unit)?,
    context: Context,
    viewModel: MainScreenViewModel = getViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect() { event ->
            if (event is UiEvent.Navigate){
                onNavigate?.let { it(event) }
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { viewModel.onEvent(MainScreenEvent.OnGuestGroupButtonClick) }) {
            Text(text = context.getString(R.string.guests_by_group))
        }
        Button(onClick = { viewModel.onEvent(MainScreenEvent.OnAllGuestsButtonClick) }) {
            Text(text = context.getString(R.string.all_guests))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InvitationListPlannerTheme {
        MainScreen(null, LocalContext.current)
    }
}
