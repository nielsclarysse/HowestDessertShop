package be.howest.annaudenaert.sweetdroiddelights.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import be.howest.annaudenaert.sweetdroiddelights.data.local.room.dao.CartDao
import be.howest.annaudenaert.sweetdroiddelights.data.local.room.entity.CartItemEntity

@Database(
    entities = [CartItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}