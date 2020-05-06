package com.worldsnas.daggerfeatures.activity.main

import com.worldsnas.daggerfeatures.di.ActivityScope
import com.worldsnas.daggerfeatures.di.AppComponent
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class]
)
interface MainComponent{
    fun inject(main : MainActivity)
}