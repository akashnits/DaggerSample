package com.example.android.dagger.di.modules

import com.example.android.dagger.storage.SharedPreferencesStorage
import com.example.android.dagger.storage.Storage
import dagger.Binds
import dagger.Module

/**
 * Created by akash on 23,April,2020
 */
@Module
abstract class StorageModule {
    @Binds
    abstract fun providesStorage(sharedPreferencesStorage: SharedPreferencesStorage) : Storage
}