package be.howest.annaudenaert.sweetdroiddelights.domain.repositories

import be.howest.annaudenaert.sweetdroiddelights.data.local.room.entity.CartItemEntity
import be.howest.annaudenaert.sweetdroiddelights.domain.model.CartItem
import kotlinx.coroutines.flow.Flow

interface ICartRepository {
    suspend fun addItem(item: CartItem)
    fun getCartItems(): Flow<List<CartItem>>
    suspend fun clearCart()
}