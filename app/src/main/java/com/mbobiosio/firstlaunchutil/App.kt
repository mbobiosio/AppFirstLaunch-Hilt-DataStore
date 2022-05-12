package com.mbobiosio.firstlaunchutil

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/*
* Created by Mbuodile Obiosio on May 12, 2022.
* Twitter: @cazewonder
* Nigeria
*/
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
