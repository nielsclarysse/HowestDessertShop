package be.howest.annaudenaert.sweetdroiddelights.domain.usecases

import be.howest.annaudenaert.sweetdroiddelights.data.local.datastore.SettingsDataStore
import javax.inject.Inject

class SubscribeToNewsletterUseCase @Inject constructor(
    private val settingsDataStore: SettingsDataStore
) {
    suspend operator fun invoke() {
        settingsDataStore.setSubscribed()
    }
}