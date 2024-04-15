package com.sopt.now.data.local.datasourceimpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.sopt.now.data.datasource.local.SoptLocalDataSource
import com.sopt.now.data.model.local.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SoptLocalDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SoptLocalDataSource {
    private object PreferencesKeys {
        val isLogin = booleanPreferencesKey(IS_LOGIN)
        val user = stringPreferencesKey(USER)
    }

    override var isLogin: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.isLogin] ?: false
    }

    override suspend fun setIsLogin(isLogin: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.isLogin] = isLogin
        }
    }

    override var user: Flow<User?> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.user]?.let { user -> Json.decodeFromString(user) }
    }

    override suspend fun setUser(user: User) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.user] = user.toJsonString()
        }
    }

    override suspend fun clear() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private const val IS_LOGIN = "isLogin"
        private const val USER = "user"
    }
}
