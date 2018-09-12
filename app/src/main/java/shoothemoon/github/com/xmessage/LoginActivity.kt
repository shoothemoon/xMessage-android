package shoothemoon.github.com.xmessage_test

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import shoothemoon.github.com.xmessage.R

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        button_Login.setOnClickListener{
            val email = email_Login.text.toString()
            val password = password_Login.text.toString()

            Log.d("LoginActivity", "Tried to login")
        }

        back_to_register.setOnClickListener {
            finish()
        }

    }


}