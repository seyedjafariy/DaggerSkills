package com.worldsnas.daggerfeatures.activity.list

import androidx.lifecycle.ViewModel
import com.worldsnas.daggerfeatures.network.UserRepository
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val repo : UserRepository
) : ViewModel()