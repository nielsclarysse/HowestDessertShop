package be.howest.annaudenaert.sweetdroiddelights.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    fun onEmailChanged(newEmail: String) {
        _uiState.update {it.copy(emailAddress = newEmail)}
    }

    fun onSubscribeClicked() {
        _uiState.update { it.copy(isSubscribed = true) }
        Log.d("HomeViewModel", "Subscription successful, email: ${_uiState.value.emailAddress}")
    }
}