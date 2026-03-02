package be.howest.annaudenaert.sweetdroiddelights.domain.usecases

import be.howest.annaudenaert.sweetdroiddelights.data.local.datastore.SettingsDataStore

class SubscribeToNewsletterUseCase(
    private val settingsDataStore: SettingsDataStore
) {
    suspend operator fun invoke() {
        settingsDataStore.setSubscribed()
    }
}