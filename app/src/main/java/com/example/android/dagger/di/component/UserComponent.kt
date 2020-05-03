package com.example.android.dagger.di.component

import com.example.android.dagger.di.scope.LoggedInUserScope
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.settings.SettingsActivity
import dagger.Subcomponent

/**
 * Created by akash on 02,May,2020
 */
@LoggedInUserScope
@Subcomponent
interface UserComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(): UserComponent
    }


    fun inject(settingsActivity: SettingsActivity)
    fun inject(mainActivity: MainActivity)
}