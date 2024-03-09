package com.example.ainews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ainews.ui.theme.AINEWSTheme
import androidx.activity.viewModels


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AINEWSTheme {
                // A surface container using the 'background' color from the theme
                val mainViewModel: MainViewModel by viewModels()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Column을 사용하여 버튼 포함
                    Column(modifier = Modifier.padding(16.dp)) {
                        Greeting("Android")
                        Spacer(modifier = Modifier.height(16.dp)) // Greeting과 Button 사이의 공간을 추가
                        // 버튼 추가
                        Button(onClick = { mainViewModel.startStreaming() }) {
                            Text("Start Radio")
                        }
                    }
                }
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
    AINEWSTheme {
        Greeting("Android")
    }
}
