package com.example.ecomove

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.ecomove.data.Users.UserViewModel


class LoginActivity : AppCompatActivity() {
    val LAUNCH_SIGN_IN_ACTIVITY = 1
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_user)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        //Create new account
        findViewById<Button>(R.id.newAccount_button).setOnClickListener {

            val intent = Intent(this, RegisterUserActivity::class.java)
            startActivityForResult(intent, LAUNCH_SIGN_IN_ACTIVITY);
        }

        //Login button
        findViewById<Button>(R.id.login_button).setOnClickListener {
            val email = findViewById<EditText>(R.id.email_editText).text.toString()
            val password = findViewById<EditText>(R.id.password_editText).text.toString()
            //Check on the database for an user with the same email and password
            mUserViewModel.validUser(email, password)

            //it = valid user, if exists one
            mUserViewModel.validUserLiveData.observe(this) {
                if (it != null) {
                    Toast.makeText(applicationContext, "Valid User", Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(applicationContext, "NOT VALID USER", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LAUNCH_SIGN_IN_ACTIVITY) {
            if (resultCode == RESULT_OK) {

            }
            if (resultCode == RESULT_CANCELED) {
                // Write your code if there's no result
            }
        }
    } //onActivityResult

}