package com.example.ecomove.data.Users

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDAO) {
    @WorkerThread
    suspend fun repeatedUser(user: User): Flow<User?> {
    return userDao.repeatedUser(user.Email)
    }
    @WorkerThread
    suspend fun validUser(user: User): Flow<User?> {
        return userDao.validUser(user.Email, user.Password)
    }

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

}