package com.example.myevcharger.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myevcharger.R
import com.example.myevcharger.databinding.ActivityMainBinding
import com.example.myevcharger.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity() : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}