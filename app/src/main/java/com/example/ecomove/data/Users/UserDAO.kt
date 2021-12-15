package com.example.ecomove.data.Users

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao

interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT Email FROM user_table ORDER BY id ASC")
    fun readAllEmails(): LiveData<List<String>>

    @Query("SELECT * FROM user_table WHERE Email = :email")
    fun repeatedUser(email: String): Flow<User?>

    @Query("SELECT * FROM user_table WHERE Password = :password AND Email = :email")
    fun validUser(email: String, password: String): Flow<User?>

}