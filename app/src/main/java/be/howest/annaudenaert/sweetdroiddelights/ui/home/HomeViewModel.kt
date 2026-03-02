package be.howest.annaudenaert.sweetdroiddelights.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.howest.annaudenaert.sweetdroiddelights.domain.usecases.GetSubscriptionStatusUseCase
import be.howest.annaudenaert.sweetdroiddelights.domain.usecases.SubscribeToNewsletterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSubscriptionStatus: GetSubscriptionStatusUseCase,
    private val subscribeToNewsletter: SubscribeToNewsletterUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            getSubscriptionStatus().collect { subscribed ->
                _uiState.update {
                    it.copy(isSubscribed = subscribed)
                }
            }
        }
    }

    fun onEmailChanged(newEmail: String) {
        _uiState.update {it.copy(emailAddress = newEmail)}
    }

    fun onSubscribeClicked() {
        viewModelScope.launch {
            subscribeToNewsletter()
        }
    }
}