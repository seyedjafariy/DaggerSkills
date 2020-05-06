package com.worldsnas.daggerfeatures.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.worldsnas.daggerfeatures.DaggerApp
import com.worldsnas.daggerfeatures.R
import com.worldsnas.daggerfeatures.fragments.ListViewModel

class ListActivity : AppCompatActivity() {

    lateinit var listViewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                DaggerApp.appComponent.provideListViewModel() as T
        }).get(ListViewModel::class.java)

    }
}