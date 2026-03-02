package be.howest.annaudenaert.sweetdroiddelights.di

import be.howest.annaudenaert.sweetdroiddelights.data.local.room.repositories.CartRepositoryImpl
import be.howest.annaudenaert.sweetdroiddelights.domain.repositories.ICartRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCartRepository(
        impl: CartRepositoryImpl
    ): ICartRepository
}