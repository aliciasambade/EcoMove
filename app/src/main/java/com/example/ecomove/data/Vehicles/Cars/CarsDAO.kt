package com.example.ecomove.data.Vehicles.Cars

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao

interface CarsDAO {
    @Query("SELECT * FROM CARS ORDER BY 1")
    fun readAllCars(): LiveData<List<Cars>>

}