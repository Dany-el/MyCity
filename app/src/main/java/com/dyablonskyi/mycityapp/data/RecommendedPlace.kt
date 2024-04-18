package com.dyablonskyi.mycityapp.data

import androidx.compose.runtime.Immutable

@Immutable
data class RecommendedPlace(
    val name: String,
    val category: Category,
    val workingTime: String = "",
    val description: String = ""
)
