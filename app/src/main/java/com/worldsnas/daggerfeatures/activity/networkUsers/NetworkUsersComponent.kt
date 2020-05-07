package com.worldsnas.daggerfeatures.activity.networkUsers

import com.worldsnas.daggerfeatures.di.ActivityScope
import com.worldsnas.daggerfeatures.di.networkcomponent.NetworkComponent
import dagger.Component

@ActivityScope
@Component(
    dependencies = [NetworkComponent::class],
    modules = [NetworkUsersModule::class]
)
interface NetworkUsersComponent {

    fun inject(activity : NetworkUsersActivity)
}