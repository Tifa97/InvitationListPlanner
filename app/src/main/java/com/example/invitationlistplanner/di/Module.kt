package com.example.invitationlistplanner.di

import com.example.invitationlistplanner.database.InvitationListRoom
import com.example.invitationlistplanner.repository.GroupRepository
import com.example.invitationlistplanner.repository.PersonRepository
import com.example.invitationlistplanner.ui.mainscreen.MainScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { GroupRepository(get()) }
    single { PersonRepository(get()) }

    single { InvitationListRoom.getInstance(androidApplication()).groupDao }
    single { InvitationListRoom.getInstance(androidApplication()).personDao }

    viewModel { MainScreenViewModel() }
}
