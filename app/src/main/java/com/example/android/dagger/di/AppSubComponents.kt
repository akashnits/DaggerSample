package com.example.android.dagger.di

import com.example.android.dagger.di.component.LoginComponent
import com.example.android.dagger.di.component.RegistrationComponent
import com.example.android.dagger.di.component.UserComponent
import dagger.Module

/**
 * Created by akash on 02,May,2020
 */
@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class, UserComponent::class])
class AppSubComponents {
}