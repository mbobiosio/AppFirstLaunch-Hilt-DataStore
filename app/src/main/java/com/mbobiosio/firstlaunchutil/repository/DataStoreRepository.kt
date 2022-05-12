package com.mbobiosio.firstlaunchutil.repository

import kotlinx.coroutines.flow.Flow

/**
 * @author Mbuodile Obiosio
 * Twitter: @cazewonder
 * DataStore Repository Interface
 */
interface DataStoreRepository {

    fun getFirstLaunch(): Flow<Boolean>

    suspend fun saveFirstLaunch(isFirstLaunch: Boolean)
}
