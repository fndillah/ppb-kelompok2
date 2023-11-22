package com.example.catatankeuangan

//import androidx.compose.runtime.Composable
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catatankeuangan.features.ProfileScreen
import com.example.catatankeuangan.features.TransactionScreen
import com.example.catatankeuangan.ui.HomeScreen
import com.example.catatankeuangan.ui.theme.CatatanKeuanganTheme
import com.example.catatankeuangan.ui.theme.DeepBlue


class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatatanKeuanganTheme{
                val navController = rememberNavController()
//                Surface(color = MaterialTheme.colorScheme.background) {

//                    HomeScree n()

                    // this is the most outer box having all the views inside it
                    Box(
                        modifier = Modifier
                            .background(DeepBlue)
                            .fillMaxSize()
                    ) {
//                    val navController = rememberNavController()
                        ScreenMain(navController = navController)

//                        BottomMenu(
//                            items = listOf(
//                                BottomMenuContent("Home", R.drawable.ic_home, "home"),
////                                BottomMenuContent("explore", R.drawable.ic_baseline_explore_24, "explore"),
////                                BottomMenuContent("dark mode", R.drawable.ic_moon, "dark"),
////                                BottomMenuContent("videos", R.drawable.ic_videocam, "videos"),
//                                BottomMenuContent("Profile", R.drawable.ic_profile, "profile"),
//                            ), modifier = Modifier.align(Alignment.BottomCenter),
//                            navController = navController
//                        )
                    }
                }

            }


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
//@Preview
fun ScreenMain(navController: NavHostController) {
//    val viewModel: TransactionViewModel = viewModel()

//    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen()
        }

        composable("profile") {
            ProfileScreen()
        }

        composable("add") {
            TransactionScreen()
        }

    }

    }