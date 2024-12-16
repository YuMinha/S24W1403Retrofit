package kr.ac.kumoh.ce.s20220703.s24w1403retrofit

import kr.ac.kumoh.ce.s20220703.s24w1403retrofit.ui.theme.S24W1403RetrofitTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S24W1403RetrofitTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val viewModel: SongViewModel = viewModel()
    val songList by viewModel.songList.observeAsState(emptyList())

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            //startDestination = SongScreen.Singer.name,
            startDestination = SongScreen.Song.name,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(route = SongScreen.Singer.name) {
                SingerList()
            }
            composable(route = SongScreen.Song.name) {
                SongList() {
                    navController.navigate(it) {
                        launchSingleTop = true
                        popUpTo(it) { inclusive = true }
                    }
                }
            }
            composable(
                route = SongScreen.SongDetail.name + "/{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.IntType
                })
            ) {
                val id = it.arguments?.getInt("id") ?: -1
                val song = songList.find { song -> song.id == id }
                if (song != null)
                    SongDetail(song)
            }
        }
    }
}
