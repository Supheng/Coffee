package kh.com.supheng.jetpack.compose.projectbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kh.com.supheng.jetpack.compose.projectbank.Model.MVVM.ScreenAC
import kh.com.supheng.jetpack.compose.projectbank.Screen.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //HomeScreen()
            ScreenAC()
        }
    }
}