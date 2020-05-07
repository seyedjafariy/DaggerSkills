package com.worldsnas.daggerfeatures.activity.main

import com.worldsnas.daggerfeatures.di.ActivityScope
import com.worldsnas.daggerfeatures.di.sharedprefcomponent.SharedPreferencesComponent
import dagger.Component

@ActivityScope
@Component(
    dependencies = [SharedPreferencesComponent::class],
    modules = [MainModule::class]
)
interface MainComponent{
    fun inject(main : MainActivity)
}