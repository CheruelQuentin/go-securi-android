package fr.tuto.gosecuriandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val etName = findViewById<EditText>(R.id.et_name)
        val etPasswd = findViewById<EditText>(R.id.et_password)
        val btnStart = findViewById<Button>(R.id.btn_start)

        val intent : Intent = Intent(this, MainActivity::class.java)

        btnStart.setOnClickListener {
            if(etName.text.isEmpty() || etPasswd.text.isEmpty()){
                Toast.makeText(this,("Insert your name or password !!"), Toast.LENGTH_SHORT).show()
            } else {

                intent.putExtra("etName", etName.text.toString())
                intent.putExtra("etPass", etPasswd.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
