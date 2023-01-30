package com.example.pgfinder

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pgfinder.ui.theme.PGFinderTheme
import com.example.pgfinder.ui.theme.Poppins
import com.example.pgfinder.ui.theme.PrimaryColor
var Email : String = ""
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PGFinderTheme {
                // A surface container using the 'background' color from the theme
//                println("Hello")
                var navController = rememberNavController()
                MainScreen(navController)
            }
        }
    }
}
