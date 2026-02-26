package be.howest.annaudenaert.sweetdroiddelights.ui.desserts.detail

import androidx.lifecycle.ViewModel
import be.howest.annaudenaert.sweetdroiddelights.data.fake.FakeDataSource
import be.howest.annaudenaert.sweetdroiddelights.domain.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DessertDetailUiState(
    val dessert: Dessert? = null,
    val error: String? = null
)

class DessertDetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DessertDetailUiState())
    val uiState: StateFlow<DessertDetailUiState> = _uiState

    fun loadDessert(dessertId: Int) {
        try {
            val result = FakeDataSource().getDessertById(dessertId)
            _uiState.update { it.copy(dessert = result) }
        } catch (e: Exception) {
            _uiState.update { it.copy(error = "Dessert could not be loaded") }
        }
    }
}