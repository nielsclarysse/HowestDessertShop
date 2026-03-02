package be.howest.annaudenaert.sweetdroiddelights.data.local.room.repositories

import be.howest.annaudenaert.sweetdroiddelights.data.local.room.dao.CartDao
import be.howest.annaudenaert.sweetdroiddelights.data.local.room.entity.CartItemEntity
import be.howest.annaudenaert.sweetdroiddelights.domain.model.CartItem
import be.howest.annaudenaert.sweetdroiddelights.domain.repositories.ICartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartRepositoryImpl(
    private val cartDao: CartDao
) : ICartRepository {

    override suspend fun addItem(item: CartItem) {
        val entity = CartItemEntity(
            id = item.id,
            name = item.name,
            price = item.price,
            quantity = 1
        )
        cartDao.insert(entity)
    }

    override fun getCartItems(): Flow<List<CartItem>> {
        return cartDao.getCartItems().map { entities ->
            entities.map {
                CartItem(
                    id = it.id,
                    name = it.name,
                    price = it.price,
                    quantity = it.quantity
                )
            }
        }
    }

    override suspend fun clearCart() {
        cartDao.clearCart()
    }
}