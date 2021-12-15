package com.example.ecomove.data.Users

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository

    val userLiveData: MutableLiveData <User?> = MutableLiveData()
    val validUserLiveData: MutableLiveData <User?> = MutableLiveData()

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
    }


    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }


    fun userRepeated(email:String) = viewModelScope.launch {
        repository.repeatedUser(User(1,"", "", email, 0,0))
            .collect { userLiveData.postValue(it) }
    }

    fun validUser(email:String, password: String) = viewModelScope.launch {
        repository.validUser(User(1,"", password, email, 0,0))
            .collect { validUserLiveData.postValue(it) }
    }

}