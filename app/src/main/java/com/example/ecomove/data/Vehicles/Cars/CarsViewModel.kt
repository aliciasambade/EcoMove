package com.example.ecomove.data.Vehicles.Cars

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ecomove.data.Users.UserRepository
import com.example.ecomove.data.Vehicles.VehiclesDatabase

class CarsViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<Cars>>
    private val repository: CarsRepository

    init {
        val carsDao = VehiclesDatabase.getDatabase(application).carsDao()
        repository = CarsRepository(carsDao)
        readAllData = repository.readAllData
    }
}