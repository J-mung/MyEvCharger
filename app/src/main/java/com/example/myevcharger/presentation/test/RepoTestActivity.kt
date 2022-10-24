package com.example.myevcharger.presentation.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myevcharger.R
import com.example.myevcharger.data.local.database.EvChargerDatabase
import com.example.myevcharger.data.local.datasource.LocalEvChargerDataSourceImpl
import com.example.myevcharger.data.remote.datasource.RemoteEvChargerDataSourceImpl
import com.example.myevcharger.data.repository.EvChargerRepositoryImpl
import com.example.myevcharger.domain.di.NetworkModule
import com.google.gson.GsonBuilder

class RepoTestActivity : AppCompatActivity() {
    lateinit var testViewModel : RepoTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // retrofit 생성 및 api 제공 -> useCase로 만들어서 바로 api 받기
        val gson = GsonBuilder().setLenient().create()
        val loggingInterceptor = NetworkModule.providesLoggerInterceptor()
        val okHttpClient = NetworkModule.providesOkHttpClient(loggingInterceptor)
        val retrofit = NetworkModule.providesRetrofit(okHttpClient, gson)
        val chargerApi = NetworkModule.providesEvChargerApi(retrofit)

        // data source 생성
        val remoteChargerDataSourceImpl = RemoteEvChargerDataSourceImpl(chargerApi)
        val localChargerDataSourceImpl = LocalEvChargerDataSourceImpl(EvChargerDatabase(this))

        // repository 생성
        val repository = EvChargerRepositoryImpl(localChargerDataSourceImpl, remoteChargerDataSourceImpl)


        val viewModelProviderFactory = ChargerViewModelProviderFactory(repository)
        testViewModel = ViewModelProvider(this, viewModelProviderFactory).get(RepoTestViewModel::class.java)


    }
}