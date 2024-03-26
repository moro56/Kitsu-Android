package com.app.core.data.di

import com.app.core.data.Repository
import com.app.core.data.RepositoryImpl
import com.app.core.local.LocalClient
import com.app.core.network.api.RestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun providesRepository(restApi: RestApi, localClient: LocalClient): Repository =
        RepositoryImpl(restApi, localClient)
}
