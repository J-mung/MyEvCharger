package com.example.myevcharger.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T: ViewDataBinding, R: BaseViewModel> : AppCompatActivity() {
    lateinit var viewDataBinding: T

    abstract val layoutResID: Int
    abstract val viewModel: R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 초기화된 layoutResId로 databinding 객체 생성
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResID)

        // live data를 사용하기 위해 set
        viewDataBinding.lifecycleOwner = this@BaseActivity
    }
}