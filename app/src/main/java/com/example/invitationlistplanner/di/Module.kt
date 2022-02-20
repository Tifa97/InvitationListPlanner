package com.example.invitationlistplanner.di

import com.example.invitationlistplanner.database.InvitationListRoom
import com.example.invitationlistplanner.repository.GuestGroupRepository
import com.example.invitationlistplanner.repository.GuestRepository
import com.example.invitationlistplanner.ui.allguestsscreen.AllGuestsViewModel
import com.example.invitationlistplanner.ui.mainscreen.MainScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { GuestGroupRepository(get()) }
    single { GuestRepository(get()) }

    single { InvitationListRoom.getInstance(androidApplication()).guestGroupDao }
    single { InvitationListRoom.getInstance(androidApplication()).guestDao }

    viewModel { MainScreenViewModel() }
    viewModel { AllGuestsViewModel(get()) }
}
