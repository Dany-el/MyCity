package com.dyablonskyi.mycityapp.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyablonskyi.mycityapp.data.RecommendedPlace
import com.dyablonskyi.mycityapp.data.coffees
import com.dyablonskyi.mycityapp.presentation.LightTheme

@Composable
fun PlaceScreen(
    places: List<RecommendedPlace>,
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxSize()) {
        Text(
            text = places[0].category.shortName,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, top = 30.dp)
        )
        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn {
            items(places) {
                Place(it.name, it.workingTime, it.description)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Place(
    name: String,
    workingTime: String,
    description: String
) {
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        onClick = { isExpanded = !isExpanded },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium,
                overflow = TextOverflow.Clip,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 18.dp)
            )
            Text(
                text = workingTime,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(10.dp)
            )
            AnimatedVisibility (isExpanded) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Clip,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@LightTheme
@Composable
private fun PlacePreview() {
    Place(
        name = "Some place",
        workingTime = "10:00 - 20:00",
        description = "Some interesting description."
    )
}

@LightTheme
@Composable
private fun PlaceScreenPreview() {
    PlaceScreen(places = coffees)
}