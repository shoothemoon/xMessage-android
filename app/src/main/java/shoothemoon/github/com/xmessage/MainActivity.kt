package shoothemoon.github.com.xmessage

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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

                            upLoadImageToStorage()
                        }
                    }
        }

        alrdy_hve_acct.setOnClickListener {
            Log.d("MainActivity", "Attempting to show loginView")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        upload_pfp.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }

    }

    var uploadedPfpUri: Uri? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            //check what image is

            uploadedPfpUri = data.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uploadedPfpUri)

            val bitmapDrawable = BitmapDrawable()
            upload_pfp.setBackgroundDrawable(bitmapDrawable)
        }

    }

    private fun upLoadImageToStorage() {
        if (uploadedPfpUri == null) return

        val filename = UUID.randomUUID().toString()
        val ref = FirebaseStorage.getInstance().getReference("/profiles/$filename")

        ref.putFile(uploadedPfpUri!!)
                .addOnSuccessListener {
                    Log.d("MainActivity", "Success pfp")
                }
    }
}

