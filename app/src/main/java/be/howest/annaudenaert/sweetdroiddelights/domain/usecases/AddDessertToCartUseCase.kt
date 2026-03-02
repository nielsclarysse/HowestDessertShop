package be.howest.annaudenaert.sweetdroiddelights.domain.usecases

import be.howest.annaudenaert.sweetdroiddelights.domain.model.CartItem
import be.howest.annaudenaert.sweetdroiddelights.domain.model.Dessert
import be.howest.annaudenaert.sweetdroiddelights.domain.repositories.ICartRepository
import jakarta.inject.Inject

class AddDessertToCartUseCase @Inject constructor(
    private val cartRepository: ICartRepository
) {
    suspend operator fun invoke(dessert: Dessert) {
        cartRepository.addItem(
            CartItem(
                id = dessert.id,
                name = dessert.name,
                price = dessert.price,
                quantity = 1
            )
        )
    }
}