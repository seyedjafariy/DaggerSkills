package com.worldsnas.daggerfeatures.activity.networkUsers

import com.worldsnas.daggerfeatures.di.ActivityScope
import com.worldsnas.daggerfeatures.di.AppComponent
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [NetworkUsersModule::class]
)
interface NetworkUsersComponent {

    fun inject(activity : NetworkUsersActivity)
}