package com.worldsnas.daggerfeatures.di.contextcomponent

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ContextScope


@ContextScope
@Component
interface ContextComponent {

    fun provideApplication() : Application

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance app : Application) : ContextComponent
    }
}