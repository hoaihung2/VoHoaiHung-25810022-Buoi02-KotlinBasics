package edu.hcmute.mobile_ute.buoi7.app.src.main.java.edu.hcmute.nagivation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import edu.hcmute.cupcake.ui.theme.CupCakeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CupCakeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CupcakeApp()
                }
            }
        }
    }
}
