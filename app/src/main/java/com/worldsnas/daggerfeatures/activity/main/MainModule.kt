package com.worldsnas.daggerfeatures.activity.main

import androidx.lifecycle.ViewModelProvider
import com.worldsnas.daggerfeatures.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {

    @Binds
    abstract fun bindViewModelFactory(factory : ViewModelFactory) :
            ViewModelProvider.Factory
}