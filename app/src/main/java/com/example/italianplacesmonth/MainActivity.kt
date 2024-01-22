package com.example.italianplacesmonth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.italianplacesmonth.data.PlacesRepository
import com.example.italianplacesmonth.layout.PlacesList
import com.example.italianplacesmonth.ui.theme.ItalianPlacesMonthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItalianPlacesMonthTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityLayout()
                }
            }
        }
    }
}

@Composable
fun MainActivityLayout() {
    PlacesList(PlacesRepository.loadPlaces())
}

@Preview(showBackground = true)
@Composable
fun MainActivityLayoutLight() {
    ItalianPlacesMonthTheme(darkTheme = false) {
        PlacesList(PlacesRepository.loadPlaces())
    }
}

@Preview(showBackground = false)
@Composable
fun MainActivityLayoutDark() {
    ItalianPlacesMonthTheme(darkTheme = true) {
        PlacesList(PlacesRepository.loadPlaces())
    }
}