package be.howest.annaudenaert.sweetdroiddelights.ui.desserts.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.howest.annaudenaert.sweetdroiddelights.data.fake.FakeDataSource
import be.howest.annaudenaert.sweetdroiddelights.domain.model.Dessert
import be.howest.annaudenaert.sweetdroiddelights.domain.usecases.AddDessertToCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DessertDetailUiState(
    val dessert: Dessert? = null,
    val error: String? = null
)

@HiltViewModel
class DessertDetailViewModel @Inject constructor(
    private val addDessertToCart: AddDessertToCartUseCase
) : ViewModel() {
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

    fun onAddToCartClicked() {
        viewModelScope.launch {
            uiState.value.dessert?.let {
                addDessertToCart(it)
            }
        }
    }
}