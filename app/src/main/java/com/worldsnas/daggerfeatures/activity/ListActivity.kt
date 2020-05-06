package com.worldsnas.daggerfeatures.activity

import android.os.Bundle
import com.worldsnas.daggerfeatures.DaggerApp
import com.worldsnas.daggerfeatures.fragments.ListViewModel
import com.worldsnas.daggerfeatures.R
import javax.inject.Inject

class ListActivity : BaseActivity() {

    @Inject
    lateinit var listViewModel : ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerApp.appComponent.inject(this)
    }
}