package com.example.invitationlistplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.invitationlistplanner.navigation.Routes
import com.example.invitationlistplanner.ui.allguestsscreen.AllGuestsScreen
import com.example.invitationlistplanner.ui.guestgroupscreen.GuestGroupScreen
import com.example.invitationlistplanner.ui.mainscreen.MainScreen
import com.example.invitationlistplanner.ui.theme.InvitationListPlannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvitationListPlannerTheme {
                val navController = rememberNavController()
                val context = LocalContext.current

                NavHost(
                    navController = navController,
                    startDestination = Routes.MAIN_SCREEN
                ) {
                    composable(Routes.MAIN_SCREEN) {
                        MainScreen(
                            onNavigate = {
                                navController.navigate(it.route)
                            },
                            context
                        )
                    }
                    composable(Routes.GROUP_LIST_SCREEN) {
                        GuestGroupScreen()
                    }
                    composable(Routes.ALL_PERSONS_SCREEN) {
                        AllGuestsScreen()
                    }
//                    composable(
//                        route = Routes.ADD_EDIT_TODO + "?todoId={todoId}",
//                        arguments = listOf(
//                            navArgument(name = "todoId") {
//                                type = NavType.IntType
//                                defaultValue = -1
//                            }
//                        )
//                    ) {
//                        AddEditTodoScreen(onPopBackStack = {
//                            navController.popBackStack()
//                        })
//                    }
                }
            }
        }
    }
}
