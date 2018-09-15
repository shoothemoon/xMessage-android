package shoothemoon.github.com.xmessage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        button_Login.setOnClickListener {
            val email = email_Login.text.toString()
            val password = password_Login.text.toString()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if(!it.isSuccessful) return@addOnCompleteListener

                        else {
                            Log.d("LoginActivity", "Logged in user")
                            email_Login.text.clear()
                            password_Login.text.clear()


                        }
                    }
        }

        back_to_register.setOnClickListener {
            finish()
        }

    }

}