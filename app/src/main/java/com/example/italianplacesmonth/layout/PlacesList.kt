package com.example.italianplacesmonth.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.italianplacesmonth.model.Place
import com.example.italianplacesmonth.ui.theme.ItalianPlacesMonthTheme

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
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.small)
            )
        }
    }
}


@Preview(showBackground = false)
@Composable
fun PlacesListItemLight() {
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