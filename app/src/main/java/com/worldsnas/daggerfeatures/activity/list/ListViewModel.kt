package com.worldsnas.daggerfeatures.activity.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.worldsnas.daggerfeatures.network.UserRepository

class ListViewModel @ViewModelInject constructor(
    private val repo : UserRepository
) : ViewModel()