package shoothemoon.github.com.xmessage

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_Register.setOnClickListener {
            val email = register_Email.text.toString()
            val password = register_Email.text.toString()

            Log.d("MainActivity", "Email is working $email")
            Log.d("MainActivity", "password is working $password")
        }

        alrdy_hve_acct.setOnClickListener {
            Log.d("MainActivity", "Attempting to show loginView")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}