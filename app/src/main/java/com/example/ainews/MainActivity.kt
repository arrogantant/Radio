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
                val mainViewModel: MainViewModel by viewModels()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        // KBS Radio Button
                        Button(onClick = { mainViewModel.startStreaming("https://ebsonair.ebs.co.kr/fmradiofamilypc/familypc1m/playlist.m3u8") }) {
                            Text("EBS Radio")
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        // MBC Radio Button
                        Button(onClick = { mainViewModel.startStreaming("MBC 스트리밍 URL") }) {
                            Text("MBC Radio")
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        // SBS Radio Button
                        Button(onClick = { mainViewModel.startStreaming("SBS 스트리밍 URL") }) {
                            Text("SBS Radio")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
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
