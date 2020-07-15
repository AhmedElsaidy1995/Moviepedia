package com.innovators.myapplication.di

import com.innovators.myapplication.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule  = module {

    factory { MovieRepository(get()) }
}