package com.app.core.data.di

import com.app.core.data.Repository
import com.app.core.data.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsRepository(repository: RepositoryImpl): Repository
}