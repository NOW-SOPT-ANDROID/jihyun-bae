package com.sopt.now.data.local.datasourceimpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.sopt.now.data.datasource.local.SoptLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SoptLocalDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SoptLocalDataSource {
    private object PreferencesKeys {
        val isLogin = booleanPreferencesKey(IS_LOGIN)
        val id = stringPreferencesKey(ID)
        val password = stringPreferencesKey(PASSWORD)
        val nickname = stringPreferencesKey(NICKNAME)
        val mbti = stringPreferencesKey(MBTI)
    }

    override var isLogin: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.isLogin] ?: false
    }

    override suspend fun setIsLogin(isLogin: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.isLogin] = isLogin
        }
    }

    override var id: Flow<String?> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.id]
    }

    override suspend fun setId(id: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.id] = id
        }
    }

    override var password: Flow<String?> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.password]
    }

    override suspend fun setPassword(password: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.password] = password
        }
    }

    override var nickname: Flow<String?> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.nickname]
    }

    override suspend fun setNickname(nickname: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.nickname] = nickname
        }
    }

    override var mbti: Flow<String?> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.mbti]
    }

    override suspend fun setMbti(mbti: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.mbti] = mbti
        }
    }

    override suspend fun clear() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private const val IS_LOGIN = "isLogin"
        private const val ID = "ID"
        private const val PASSWORD = "password"
        private const val NICKNAME = "nickname"
        private const val MBTI = "mbti"
    }
}
