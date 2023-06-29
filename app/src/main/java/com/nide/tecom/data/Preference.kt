package com.nide.tecom.data

import android.content.Context
import androidx.datastore.core.DataStore

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.asLiveData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nide.tecom.data.model.AddressModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.coroutines.coroutineContext


class LocalPreference constructor(context: Context) {

    private val applicationContext = context.applicationContext
    private val Context.localDataStore: DataStore<Preferences> by preferencesDataStore("localStore")

    companion object {
        val DEFAULT_ADDRESS_KEY = stringPreferencesKey("default_address")

    }

    suspend fun setAddress(address: AddressModel) = applicationContext.localDataStore.edit { pref ->
        pref.remove(DEFAULT_ADDRESS_KEY)
        val addString = Gson().toJson(address)
        pref[DEFAULT_ADDRESS_KEY] = addString
    }

    fun getAddress() = applicationContext.localDataStore.data.map { pref ->
        val address = pref[DEFAULT_ADDRESS_KEY] ?: ""
        Gson().fromJson(address, AddressModel::class.java)
    }.asLiveData()


}


