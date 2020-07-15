package com.innovators.myapplication.di

import com.innovators.myapplication.ui.detail.DetailViewModel
import com.innovators.myapplication.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}