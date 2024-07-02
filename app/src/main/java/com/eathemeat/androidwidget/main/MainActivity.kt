package com.eathemeat.androidwidget.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eathemeat.androidwidget.databinding.ActivityMainBinding
import com.eathemeat.androidwidget.main.ui.theme.AndroidWidgetTheme
import com.eathemeat.androidwidget.slide.SlideActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            clSlide.setOnClickListener() {
                var intent = Intent(it.context,SlideActivity::class.java)
                it.context.startActivity(intent)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidWidgetTheme {
        Greeting("Android")
    }
}