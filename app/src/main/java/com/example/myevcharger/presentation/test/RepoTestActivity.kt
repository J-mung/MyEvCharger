package com.example.myevcharger.presentation.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myevcharger.R
import com.example.myevcharger.data.database.EvChargerDatabase
import com.example.myevcharger.data.local.repository.LocalEvChargerRepositoryImpl

class RepoTestActivity : AppCompatActivity() {
    lateinit var testViewModel : RepoTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chargerRepositoryImpl = LocalEvChargerRepositoryImpl(EvChargerDatabase(this))
        val viewModelProviderFactory = ChargerViewModelProviderFactory(chargerRepositoryImpl)
        testViewModel = ViewModelProvider(this, viewModelProviderFactory).get(RepoTestViewModel::class.java)


    }
}