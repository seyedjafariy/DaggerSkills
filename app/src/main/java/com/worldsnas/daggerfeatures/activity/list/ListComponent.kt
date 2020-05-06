package com.worldsnas.daggerfeatures.activity.list

import com.worldsnas.daggerfeatures.di.ActivityScope
import com.worldsnas.daggerfeatures.di.AppComponent
import com.worldsnas.daggerfeatures.fragments.ListViewModel
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class]
)
interface ListComponent {

    fun provideViewModel() : ListViewModel

    fun inject(activity: ListActivity)
}