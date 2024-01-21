package com.example.italianplacesmonth.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.italianplacesmonth.R
import com.example.italianplacesmonth.data.PlacesRepository
import com.example.italianplacesmonth.model.Place
import com.example.italianplacesmonth.ui.theme.ItalianPlacesMonthTheme


@Composable
fun PlacesListOpened(places: List<Place>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(places) {
            PlacesListItemOpened(place = it)
        }
    }
}

@Composable
fun PlacesListItemOpened(place: Place, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(place.title),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(
                    R.string.description,
                    stringResource(place.city),
                    stringResource(place.region),
                    stringResource(place.year)
                ),
                style = MaterialTheme.typography.bodySmall
            )
            Image(
                painter = painterResource(place.image),
                contentDescription = stringResource(place.title),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.small)
            )
        }
    }
}

@Composable
fun PlacesListItemClosed(place: Place, index: Int, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(place.title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = stringResource(R.string.day, (index + 1)),
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PlacesListOpenedLight() {
    ItalianPlacesMonthTheme(darkTheme = false) {
        PlacesListOpened(places = PlacesRepository.loadPlaces())
    }
}

@Preview(showBackground = false)
@Composable
fun PlacesListOpenedDark() {
    ItalianPlacesMonthTheme(darkTheme = true) {
        PlacesListOpened(places = PlacesRepository.loadPlaces())
    }
}


@Preview(showBackground = false)
@Composable
fun PlacesListItemOpenedLight() {
    ItalianPlacesMonthTheme(darkTheme = false) {
        PlacesListItemOpened(
            place = Place(
                title = R.string.title_1,
                city = R.string.city_1,
                region = R.string.region_1,
                year = R.string.year_1,
                image = R.drawable.image_1
            )
        )
    }
}

@Preview(showBackground = false)
@Composable
fun PlacesListItemClosedLight() {
    ItalianPlacesMonthTheme(darkTheme = false) {
        PlacesListItemClosed(
            place = Place(
                title = R.string.title_1,
                city = R.string.city_1,
                region = R.string.region_1,
                year = R.string.year_1,
                image = R.drawable.image_1
            ),
            index = 0
        )
    }
}

@Preview(showBackground = false)
@Composable
fun PlacesListItemDark() {
    ItalianPlacesMonthTheme(darkTheme = true) {
        PlacesListItemOpened(
            place = Place(
                title = R.string.title_1,
                city = R.string.city_1,
                region = R.string.region_1,
                year = R.string.year_1,
                image = R.drawable.image_1
            )
        )
    }
}

@Preview(showBackground = false)
@Composable
fun PlacesListItemClosedDark() {
    ItalianPlacesMonthTheme(darkTheme = true) {
        PlacesListItemClosed(
            place = Place(
                title = R.string.title_1,
                city = R.string.city_1,
                region = R.string.region_1,
                year = R.string.year_1,
                image = R.drawable.image_1
            ),
            index = 0
        )
    }
}