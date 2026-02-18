package be.howest.annaudenaert.sweetdroiddelights.ui.desserts

import android.util.Log
import androidx.lifecycle.ViewModel
import be.howest.annaudenaert.sweetdroiddelights.data.fake.FakeDataSource
import be.howest.annaudenaert.sweetdroiddelights.domain.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DessertListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DessertListUiState())
    val uiState: StateFlow<DessertListUiState> = _uiState

    init {
        loadDesserts()
    }

    private fun loadDesserts() {
        val desserts = FakeDataSource().loadDesserts()
        _uiState.value = uiState.value.copy(desserts = desserts)
    }

    fun onDessertClicked(dessert: Dessert) {
        Log.d("DessertListViewModel", "Dessert clicked, id: ${dessert.id}")
    }
}