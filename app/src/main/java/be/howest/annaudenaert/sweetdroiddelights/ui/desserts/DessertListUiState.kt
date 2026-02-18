package be.howest.annaudenaert.sweetdroiddelights.ui.desserts

import be.howest.annaudenaert.sweetdroiddelights.domain.model.Dessert

data class DessertListUiState(
    val desserts: List<Dessert> = emptyList()
)