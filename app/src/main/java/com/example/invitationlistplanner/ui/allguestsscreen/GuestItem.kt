package com.example.invitationlistplanner.ui.allguestsscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.invitationlistplanner.database.entity.Guest
import com.example.invitationlistplanner.ui.theme.InvitationListPlannerTheme

@Composable
fun GuestItem(
    guest: Guest,
    onEvent: (AllGuestsScreenEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(border = BorderStroke(1.dp, Color.LightGray)),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .padding(20.dp),
            text = guest.name
        )
        Box(
            modifier = Modifier.fillMaxSize(0.4f)
        ) {
            guest.isAdult?.let {
                if (it) Icon(Icons.Default.Person, "", Modifier.padding(vertical = 20.dp))
            }
        }
        IconButton(
            onClick = { onEvent(AllGuestsScreenEvent.OnDeleteGuestClick(guest)) },
            modifier = Modifier
                .padding(vertical = 20.dp)
                .size(32.dp)
        ) {
            Icon(
                Icons.Default.Delete,
                "",
                Modifier.fillMaxSize()
            )
        }
    }
}
