package com.worldsnas.daggerfeatures.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity : AppCompatActivity() {

    abstract var viewModelFactory: ViewModelProvider.Factory
}