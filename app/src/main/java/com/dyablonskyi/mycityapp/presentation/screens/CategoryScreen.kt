package com.dyablonskyi.mycityapp.presentation.screens

import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dyablonskyi.mycityapp.data.Category
import com.dyablonskyi.mycityapp.presentation.DarkTheme
import com.dyablonskyi.mycityapp.presentation.LightTheme

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    categories: List<Category> = Category.entries,
    onItemClick: (Category) -> Unit = {}
) {
    Column(modifier.fillMaxSize()) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, top = 20.dp)
        )
        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn {
            items(categories) {
                CategoryItem(name = it.shortName) {
                    onItemClick(it)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryItem(
    name: String,
    onItemClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(10.dp),
        onClick = onItemClick
    ) {
        Box(
            Modifier.fillMaxSize()
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@LightTheme
@DarkTheme
@Composable
private fun CategoryItemPreview() {
    CategoryItem(name = "Coffee")
}

@LightTheme
@DarkTheme
@Composable
private fun CategoryScreenPreview() {
    CategoryScreen()
}

