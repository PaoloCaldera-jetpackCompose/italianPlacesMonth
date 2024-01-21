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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
fun PlacesList(places: List<Place>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(places) { index, place ->
            PlacesListItem(place = place, index = index)
        }
    }
}


@Composable
fun PlacesListItem(place: Place, index: Int, modifier: Modifier = Modifier) {
    var isItemClosed by remember { mutableStateOf(true) }

    if (isItemClosed) {
        // Layout configuration when the card is CLOSED
        PlacesListItemClosed(
            place = place,
            index = index,
            onClick = { isItemClosed = !isItemClosed },
            modifier = modifier
        )
    } else {
        // Layout configuration when the card is OPENED
        PlacesListItemOpened(
            place = place,
            onClick = { isItemClosed = !isItemClosed },
            modifier = modifier
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlacesListItemClosed(
    place: Place,
    index: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        onClick = onClick
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlacesListItemOpened(
    place: Place,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        onClick = onClick
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


@Preview(showBackground = true)
@Composable
fun PlacesListLight() {
    ItalianPlacesMonthTheme(darkTheme = false) {
        PlacesList(places = PlacesRepository.loadPlaces())
    }
}

@Preview(showBackground = false)
@Composable
fun PlacesListDark() {
    ItalianPlacesMonthTheme(darkTheme = true) {
        PlacesList(places = PlacesRepository.loadPlaces())
    }
}