package shoothemoon.github.com.xmessage

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_Register.setOnClickListener {
            val email = register_Email.text.toString()
            val password = register_Email.text.toString()

            if (email.isEmpty() || password.isEmpty()) return@setOnClickListener

            Log.d("MainActivity", "Email is working $email")
            Log.d("MainActivity", "password is working $password")


            //auth crap?
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if(!it.isSuccessful) return@addOnCompleteListener

                        else {
                            Log.d("MainActivity", "Created user with uid: ${it.result.user.uid}")
                            register_Email.text.clear()
                            register_Password.text.clear()


                        }
                    }
        }

        alrdy_hve_acct.setOnClickListener {
            Log.d("MainActivity", "Attempting to show loginView")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

}