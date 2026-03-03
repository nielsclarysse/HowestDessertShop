package be.howest.annaudenaert.sweetdroiddelights.domain.usecases

import be.howest.annaudenaert.sweetdroiddelights.domain.model.CartItem
import be.howest.annaudenaert.sweetdroiddelights.domain.repositories.ICartRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetCartItemsUseCase @Inject constructor(
    private val cartRepository: ICartRepository
) {
    operator fun invoke(): Flow<List<CartItem>> = cartRepository.getCartItems()
}