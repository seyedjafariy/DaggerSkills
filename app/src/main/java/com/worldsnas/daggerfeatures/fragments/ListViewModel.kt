package com.worldsnas.daggerfeatures.fragments

import androidx.lifecycle.ViewModel
import com.worldsnas.daggerfeatures.network.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListViewModel @Inject constructor(
    private val repo : UserRepository
) : ViewModel()