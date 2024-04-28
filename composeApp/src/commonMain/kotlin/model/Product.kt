package model

import kotlinx.serialization.Serializable


@Serializable
data class Product(
    val id : Int? = null,
    val name : String? = null,
    val img: String? = null,
    val price : String? = null,
    val description : String? = null,
)
