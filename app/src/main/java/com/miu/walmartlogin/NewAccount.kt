package com.miu.walmartlogin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.btnCreate
import kotlinx.android.synthetic.main.activity_new_account.*

class NewAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)
        btnCreate.setOnClickListener{
            var fName = etFirstName.text.toString()
            var lName = etLastName.text.toString()
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()
            if(fName != null && lName != null && email != null && password != null){
                Toast.makeText(this,"Account created successfully",Toast.LENGTH_LONG).show()
                val newUser = User(fName, lName, email, password)
                val rintent = intent

                val user1 = fName + "_" + lName + "_" + email + "_" + password
                rintent.data = Uri.parse(user1)
                setResult(Activity.RESULT_OK, rintent)
                finish()
            } else {
                Toast.makeText(this,"Something is wrong",Toast.LENGTH_LONG).show()
            }

        }
    }
}