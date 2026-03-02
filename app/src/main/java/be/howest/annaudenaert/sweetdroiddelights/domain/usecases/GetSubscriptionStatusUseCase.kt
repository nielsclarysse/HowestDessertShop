package be.howest.annaudenaert.sweetdroiddelights.domain.usecases

import be.howest.annaudenaert.sweetdroiddelights.data.local.datastore.SettingsDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSubscriptionStatusUseCase @Inject constructor(
    private val settingsDataStore: SettingsDataStore
) {
    operator fun invoke(): Flow<Boolean> {
        return settingsDataStore.isSubscribed
    }
}