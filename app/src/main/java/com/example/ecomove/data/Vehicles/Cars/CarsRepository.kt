package com.example.ecomove.data.Vehicles.Cars

import androidx.lifecycle.LiveData

class CarsRepository(private val carsDAO: CarsDAO) {

    val readAllData: LiveData<List<Cars>> = carsDAO.readAllCars()

}