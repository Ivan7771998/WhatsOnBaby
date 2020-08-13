package com.dev777popov.whatsonbaby

import android.app.Application

class App : Application() {

    override fun onCreate() {
        sharedPref = SharedPref(applicationContext)
        super.onCreate()
    }

    companion object {
        private lateinit var app: App

        var sharedPref: SharedPref? = null

        fun getInstance(): App {
            return app
        }
    }
}