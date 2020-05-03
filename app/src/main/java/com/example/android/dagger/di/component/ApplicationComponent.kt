package com.example.android.dagger.di.component

import android.content.Context
import com.example.android.dagger.di.AppSubComponents
import com.example.android.dagger.di.modules.StorageModule
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.settings.SettingsActivity
import com.example.android.dagger.user.UserManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by akash on 23,April,2020
 */
@Singleton
@Component(modules = [StorageModule::class, AppSubComponents::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }

    fun registrationComponent(): RegistrationComponent.Factory

    fun loginComponent(): LoginComponent.Factory

    fun userManager(): UserManager

}