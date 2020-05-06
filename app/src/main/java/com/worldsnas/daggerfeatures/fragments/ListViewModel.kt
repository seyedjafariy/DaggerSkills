package com.worldsnas.daggerfeatures.fragments

import androidx.lifecycle.ViewModel
import com.worldsnas.daggerfeatures.db.DaggerDatabase
import com.worldsnas.daggerfeatures.network.UserRepositoryImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListViewModel @Inject constructor(
    private val repo : UserRepositoryImpl
) : ViewModel()