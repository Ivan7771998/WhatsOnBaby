package com.dev777popov.whatsonbaby.ui.activities.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev777popov.whatsonbaby.App
import com.dev777popov.whatsonbaby.App.Companion.getInstance
import com.dev777popov.whatsonbaby.App.Companion.sharedPref

class WeatherViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = sharedPref?.getNameMom()
    }
    val text: LiveData<String> = _text
}