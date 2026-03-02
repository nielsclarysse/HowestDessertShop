package be.howest.annaudenaert.sweetdroiddelights.di

import android.content.Context
import androidx.room.Room
import be.howest.annaudenaert.sweetdroiddelights.data.local.room.dao.CartDao
import be.howest.annaudenaert.sweetdroiddelights.data.local.room.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "sweetdroid-db"
        ).build()

    @Provides
    fun provideCartDao(db: AppDatabase): CartDao =
        db.cartDao()
}