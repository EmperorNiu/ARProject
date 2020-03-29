package com.example.arproject.network

data class Building (
    val Id: Int,
    val Name: String,
    val description: String
)
data class Buildings (
    val building_list:List<Building>
)
data class Position (
    val latitude:Double,
    val longitude:Double
)


