package com.innovators.myapplication.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<D : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    lateinit var viewModel: V
    lateinit var dataBinding: D

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performDatabinding()
    }

    private fun performDatabinding() {
        this.viewModel = getMyViewModel()
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        dataBinding.setVariable(getBindingVariable(), viewModel)
        dataBinding.executePendingBindings()
    }

    abstract fun getMyViewModel(): V

    abstract fun getBindingVariable(): Int

    abstract fun getLayoutId(): Int
}