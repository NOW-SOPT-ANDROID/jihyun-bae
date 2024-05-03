package com.sopt.now.data.local.datasourceimpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.sopt.now.data.local.datasource.SoptLocalDataSource
import com.sopt.now.data.local.model.User
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
        val userId = intPreferencesKey(USER_ID)
    }

    override var isLogin: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.isLogin] ?: false
    }

    override suspend fun setIsLogin(isLogin: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.isLogin] = isLogin
        }
    }

    override var userId: Flow<Int?> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.userId]
    }

    override suspend fun setUserId(userId: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.userId] = userId
        }
    }

    override suspend fun clear() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private const val IS_LOGIN = "isLogin"
        private const val USER_ID = "userId"
    }
}
