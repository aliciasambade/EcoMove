package com.example.ecomove.data.Vehicles.Cars

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity

@Entity(tableName = "CARS")
data class Cars(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val Make_and_Model: String,
    val Autonomy: Int,
    val Price: Double
)