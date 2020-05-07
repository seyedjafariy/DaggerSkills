package com.worldsnas.daggerfeatures.activity.list

import com.worldsnas.daggerfeatures.di.ActivityScope
import com.worldsnas.daggerfeatures.di.databasecomponent.DatabaseComponent
import dagger.Component

@ActivityScope
@Component(
    dependencies = [DatabaseComponent::class],
    modules = [ListModule::class]
)
interface ListComponent {

    fun provideViewModel() : ListViewModel

    fun inject(activity: ListActivity)
}