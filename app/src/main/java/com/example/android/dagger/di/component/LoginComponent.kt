package com.example.android.dagger.di.component

import com.example.android.dagger.di.scope.ActivityScope
import com.example.android.dagger.login.LoginActivity
import dagger.Subcomponent

/**
 * Created by akash on 02,May,2020
 */
@ActivityScope
@Subcomponent
interface LoginComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(): LoginComponent
    }

    fun inject (loginActivity: LoginActivity)
}