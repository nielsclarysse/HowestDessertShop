package be.howest.annaudenaert.sweetdroiddelights.domain.model

data class Dessert(
    val id: Int = 0,
    val imageFile: Int,
    val name: String,
    val description: String,
    val size: Int,
    val price: Double
)