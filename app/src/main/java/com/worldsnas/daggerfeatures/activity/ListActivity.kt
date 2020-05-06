package com.worldsnas.daggerfeatures.activity

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.worldsnas.daggerfeatures.DaggerApp
import com.worldsnas.daggerfeatures.fragments.ListViewModel
import com.worldsnas.daggerfeatures.R
import javax.inject.Inject

class ListActivity : BaseActivity() {

    lateinit var listViewModel : ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                DaggerApp.appComponent.provideListViewModel() as T
        }).get(ListViewModel::class.java)

    }
}