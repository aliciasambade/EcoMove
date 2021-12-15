package com.example.ecomove.data.Users

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val Name: String,
    val Password: String,
    val Email: String,
    val Age: Int,
    val PhoneNumber: Int
)