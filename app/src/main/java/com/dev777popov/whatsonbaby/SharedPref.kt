package com.dev777popov.whatsonbaby

import android.content.Context


class SharedPref(val context: Context) {

    private val MY_SETTINGS = "my_settings"
    private val NAME_MOM = "name_mother"
    private val NAME_CHILD = "name_child"
    private val prefs = context.getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE)

    fun setNameMom(name: String) {
        prefs.edit().putString(NAME_MOM, name).apply()
    }

    fun getNameMom(): String? {
        return prefs.getString(NAME_MOM, "")
    }

    fun setNameChild(name: String) {
        prefs.edit().putString(NAME_CHILD, name).apply()
    }

    fun getNameChild(): String? {
        return prefs.getString(NAME_CHILD, "")
    }

}