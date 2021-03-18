package com.prologger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_log_screen.*

class AddLogScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_log_screen)

        btnLogEmail.setOnClickListener {
            //logOn()
        }

        btnFirstScreen.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }



    override fun onResume() {
        super.onResume()
    }
}