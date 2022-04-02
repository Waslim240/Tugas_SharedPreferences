package waslim.binar.andlima.tugas

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var sharedPrefe : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (getSharedPreferences("data", Context.MODE_PRIVATE).contains("USR") &&
            getSharedPreferences("data", Context.MODE_PRIVATE).contains("PSW")) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        } else{
            sharedPrefe = getSharedPreferences("data", Context.MODE_PRIVATE)
            lgn()
        }
    }

    private fun lgn (){

        login.setOnClickListener {
            val usr = editTextEmail.text.toString()
            val lgn = editTextPassword.text.toString()

            if (usr == "waslim" && lgn == "lim123"){
                val sf = sharedPrefe.edit()
                sf.putString("USR", usr)
                sf.putString("PSW", lgn)
                sf.apply()
                startActivity(Intent(this, HomeActivity::class.java))
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_LONG).show()
                finish()
            } else{
                Toast.makeText(this, "Periksa kembali username dan password", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

}