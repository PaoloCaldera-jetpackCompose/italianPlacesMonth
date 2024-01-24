package com.example.italianplacesmonth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Scaffold(
        topBar = { ItalianPlacesTopAppBar() }
    ) {
        PlacesList(
            places = PlacesRepository.loadPlaces(),
            contentPadding = it
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItalianPlacesTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.italy_app_bar),
                contentDescription = stringResource(
                    R.string.app_bar_image
                ),
                modifier = Modifier.size(72.dp, 72.dp).padding(end = 8.dp)
            )
            Text(
                text = stringResource(R.string.app_bar_title),
                style = MaterialTheme.typography.displayMedium
            )
        }
    })
}

@Preview(showBackground = true)
@Composable
fun MainActivityLayoutLight() {
    ItalianPlacesMonthTheme(darkTheme = false) {
        MainActivityLayout()
    }
}

@Preview(showBackground = false)
@Composable
fun MainActivityLayoutDark() {
    ItalianPlacesMonthTheme(darkTheme = true) {
        MainActivityLayout()
    }
}