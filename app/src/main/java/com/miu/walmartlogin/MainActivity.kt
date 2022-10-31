package com.miu.walmartlogin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var userArr = arrayOf(
        User("Asma","Aiouez","asma@miu.edu","123")
        ,User("Sarra","Sarra","sarra@miu.edu","123")
        ,User("Amira","Amira","amira@miu.edu","123")
        ,User("Amina","Amina","amina@miu.edu","123")
        ,User("Selma","Selma","selma@miu.edu","123"))

    var resultContracts =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == Activity.RESULT_OK) {
                var res = result.data?.data.toString()
                var delimiter = "_"

                val parts = res.split(delimiter)


                val newUsr = User(parts[0], parts[1], parts[2], parts[3])
                userArr = userArr.plus(newUsr)
                println(newUsr)
                println("asma")
                for(u in userArr)
                    println(u)
            }
            else
                Toast.makeText(this, "Failed to get results", Toast.LENGTH_LONG).show()

        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSignIn.setOnClickListener{
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()
            for(u in userArr){
                if(u.username == email && u.password == password){
                    //Toast.makeText(this,email.toString(),Toast.LENGTH_LONG).show()
                    //pass the user name to
                    val intent = Intent(this,ShoppingCategory::class.java)
                    intent.putExtra("username",email)
                    startActivity(intent)
                    break
                }else{
                    Toast.makeText(this,"Unable to login. Please try again!",Toast.LENGTH_LONG).show()
                }
            }

        }

        btnCreate.setOnClickListener{
            val intent = Intent(this,NewAccount::class.java)
            resultContracts.launch(intent)
        }

        tvForgetPassword.setOnClickListener{
            var email = etEmail.text.toString()
            for (u in userArr) {
                if(u.username == email)
                    Toast.makeText(this, "Account Found. Password is " + u.password , Toast.LENGTH_LONG).show()
            }

        }
    }

}