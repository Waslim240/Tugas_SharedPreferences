package waslim.binar.andlima.tugas

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var sharedPrefe : SharedPreferences

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sharedPrefe = getSharedPreferences("data", Context.MODE_PRIVATE)

        val ambilData = sharedPrefe.getString("USR", "")
        helo_username.text = "Hello, $ambilData"

        lgt()
    }

    private fun lgt (){
        logout.setOnClickListener {
            val a = AlertDialog.Builder(this)
            a.setTitle("Logout")
            a.setMessage("Yakin Ingin Logout ... ?")
            a.setCancelable(false)
            val ab = a.create()

            a.setPositiveButton("Ya"){ dialogInterface: DialogInterface, i: Int ->
                val sf = sharedPrefe.edit()
                sf.clear()
                sf.apply()
                startActivity(Intent(this, LoginActivity::class.java))
                Toast.makeText(this,"Berhasil keluar", Toast.LENGTH_LONG).show()
                finish()
            }

                .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                    ab.dismiss()
                    Toast.makeText(this,"Tidak jadi Keluar", Toast.LENGTH_LONG).show()
                }
            a.show()
        }
    }


}