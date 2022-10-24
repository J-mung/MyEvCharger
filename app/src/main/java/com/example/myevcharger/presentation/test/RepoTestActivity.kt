package com.example.myevcharger.presentation.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myevcharger.R

class RepoTestActivity : AppCompatActivity() {
    lateinit var testViewModel : RepoTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}