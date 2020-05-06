package com.worldsnas.daggerfeatures.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.worldsnas.daggerfeatures.R
import com.worldsnas.daggerfeatures.di.findAppComponent
import com.worldsnas.daggerfeatures.fragments.ListViewModel
import javax.inject.Inject
import javax.inject.Provider

class ListActivity : AppCompatActivity() {

    lateinit var listViewModel: ListViewModel

    @Inject
    lateinit var viewModelProvider: Provider<ListViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findAppComponent().inject(this)

        listViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                viewModelProvider.get() as T
        }).get(ListViewModel::class.java)

    }
}