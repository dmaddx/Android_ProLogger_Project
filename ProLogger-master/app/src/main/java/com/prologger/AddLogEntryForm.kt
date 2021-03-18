package com.prologger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.prologger.dto.Log
import com.prologger.ui.main.MainViewModel

import kotlinx.android.synthetic.main.activity_add_log_entry_form.*

class AddLogEntryForm : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_log_entry_form)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        btnHomeScreenButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSaveLogEntry.setOnClickListener {
            saveMyLog()
        }
    }


    private fun saveMyLog() {
        var myNewLog = Log().apply {
            logName = txtlogName.text.toString()
            streetName = txtStreetName.text.toString()
            cityName = txtCityName.text.toString()
            cityCountyName = txtCountyName.text.toString()
            stateName = txtStateName.text.toString()
            countryName = txtCountyName.text.toString()
            dateStarted = txtDateStarted.text.toString()
        }
        //viewModel.save(myNewLog)
    }
}