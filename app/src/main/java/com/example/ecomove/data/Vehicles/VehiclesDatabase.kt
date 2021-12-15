package com.example.ecomove.data.Vehicles

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ecomove.data.Vehicles.Cars.Cars
import com.example.ecomove.data.Vehicles.Cars.CarsDAO

@Database(entities = [Cars::class], version = 1, exportSchema = false)
abstract class VehiclesDatabase : RoomDatabase() {

    abstract fun carsDao(): CarsDAO

    companion object {
        @Volatile
        var INSTANCE: VehiclesDatabase? = null

        fun getDatabase(context: Context): VehiclesDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VehiclesDatabase::class.java,
                    "vehicles_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}