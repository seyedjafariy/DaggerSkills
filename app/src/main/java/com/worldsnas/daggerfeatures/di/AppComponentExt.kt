package com.worldsnas.daggerfeatures.di

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment

fun Context.findAppComponent(): AppComponent =
    (applicationContext as? AppComponentProvider)
        ?.provideAppComponent()
        ?: throw IllegalStateException("application class must implement AppComponentProvider")

fun View.findAppComponent(): AppComponent =
    context.findAppComponent()

fun Fragment.findAppComponent(): AppComponent =
    requireContext().findAppComponent()