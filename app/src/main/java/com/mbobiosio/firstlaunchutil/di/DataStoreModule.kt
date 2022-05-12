package com.mbobiosio.firstlaunchutil.di

import com.mbobiosio.firstlaunchutil.repository.DataStoreImpl
import com.mbobiosio.firstlaunchutil.repository.DataStoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Mbuodile Obiosio
 * Twitter: @cazewonder
 * Binds DataStore Interface
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {

    @Singleton
    @Binds
    abstract fun bindDataStore(dataStoreImpl: DataStoreImpl): DataStoreRepository
}
