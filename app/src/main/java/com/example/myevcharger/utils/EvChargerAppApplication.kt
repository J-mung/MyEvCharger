package com.example.myevcharger.utils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EvChargerAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()

    }
}