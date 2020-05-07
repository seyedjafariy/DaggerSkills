package com.worldsnas.daggerfeatures.di.sharedprefcomponent

import android.content.SharedPreferences
import com.worldsnas.daggerfeatures.di.contextcomponent.ContextComponent
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SharedPrefScope


@SharedPrefScope
@Component(
    dependencies = [ContextComponent::class],
    modules = [SharedPrefModule::class]
)
interface SharedPreferencesComponent {

    fun provideSharedPrefs(): SharedPreferences

    @Component.Factory
    interface Factory {
        fun create(contextComp : ContextComponent) : SharedPreferencesComponent
    }
}