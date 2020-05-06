package com.worldsnas.daggerfeatures.fragments

import androidx.fragment.app.Fragment
import com.worldsnas.daggerfeatures.db.DaggerDatabase
import javax.inject.Inject

class FirstFragment : Fragment() {

    @Inject
    lateinit var database : DaggerDatabase

}