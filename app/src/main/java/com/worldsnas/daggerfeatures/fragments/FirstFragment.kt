package com.worldsnas.daggerfeatures.fragments

import androidx.fragment.app.Fragment
import com.worldsnas.daggerfeatures.db.DaggerDatabase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    @Inject
    lateinit var database : DaggerDatabase

}