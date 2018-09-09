package shoothemoon.github.com.xmessage

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = register_Email.text.toString()
        val password = register_Password.text.toString()

        button_Register.setOnClickListener {
            println("Email: $email, Password: $password")
        }

        alrdy_hve_acct.setOnClickListener {
            Log.d("MainActivity", "Clicked to show login activity")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
