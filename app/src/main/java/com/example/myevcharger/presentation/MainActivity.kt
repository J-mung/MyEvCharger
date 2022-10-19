package com.example.myevcharger.presentation

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.example.myevcharger.R
import com.example.myevcharger.databinding.ActivityMainBinding
import com.example.myevcharger.domain.model.EvChargerResponse
import com.example.myevcharger.domain.repository.local.LocalEvChargerRepository
import com.example.myevcharger.presentation.base.BaseActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*
        var tv: TextView = findViewById(R.id.tv)
        tv.setText("Hello world!")
        */
    }

    fun getChargerList() {
        val repository: LocalEvChargerRepository
        repository.getAllCharger().toString()
    }
}