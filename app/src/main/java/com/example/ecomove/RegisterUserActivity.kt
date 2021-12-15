package com.example.ecomove

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.ecomove.data.Users.User
import com.example.ecomove.data.Users.UserViewModel

//      ELIMINAR OBSERVER


class RegisterUserActivity : AppCompatActivity() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        findViewById<Button>(R.id.submitToDB_button).setOnClickListener {

            //          COMPROBAR QUE EMAIL NO ESTA VACIO AQUI


            val email = findViewById<EditText>(R.id.newEmail_editText).text.toString()
            //Check the database for an user with the same email
            mUserViewModel.userRepeated(email)
            //it = user with the same email, if exists

        }
        mUserViewModel.userLiveData.observe(this) {
            if (it != null) {
                Toast.makeText(applicationContext, "An account with that email already exists", Toast.LENGTH_LONG)
                    .show()
            } else {
                insertNewUserToDB()

            }
        }



    }

    private fun insertNewUserToDB() {
        val name = findViewById<EditText>(R.id.newName_editText).text.toString()
        val password = findViewById<EditText>(R.id.newPassword_editText).text.toString()
        val age = Integer.parseInt(findViewById<EditText>(R.id.newAge_editText).text.toString())
        val email = findViewById<EditText>(R.id.newEmail_editText).text.toString()
        val phoneNumber =
            Integer.parseInt(findViewById<EditText>(R.id.newPhoneNumber_editText).text.toString())

        if (!(name.isEmpty() && password.isEmpty() && age.equals(null) && email.isEmpty() && phoneNumber.equals(
                null
            ))
        ) {
            //Create User Object
            val user = User(0, name, password, email, age, phoneNumber)
            mUserViewModel.addUser(user)
            Toast.makeText(applicationContext, "Successfully added!", Toast.LENGTH_LONG).show()
            backToLogin()
        } else {
            Toast.makeText(applicationContext, "Please, fill out all the fields", Toast.LENGTH_LONG)
                .show()
        }
    }


    private fun backToLogin() {
        val intent = Intent()
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}