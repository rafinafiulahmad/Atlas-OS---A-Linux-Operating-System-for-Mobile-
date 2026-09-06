package com.atlas.mobile.agent

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AtlasApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
