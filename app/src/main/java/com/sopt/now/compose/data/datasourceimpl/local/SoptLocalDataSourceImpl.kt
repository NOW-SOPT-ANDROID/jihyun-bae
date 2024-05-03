package com.sopt.now.compose.data.datasourceimpl.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.sopt.now.BuildConfig
import com.sopt.now.compose.data.datasource.local.SoptLocalDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class SoptLocalDataSourceImpl @Inject constructor(
    @ApplicationContext context: Context
) : SoptLocalDataSource {
    private val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val pref: SharedPreferences =
        if (BuildConfig.DEBUG) {
            context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        } else {
            EncryptedSharedPreferences.create(
                context,
                FILE_NAME,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        }

    override var isLogin: Boolean
        get() = pref.getBoolean(IS_LOGIN, false)
        set(value) = pref.edit { putBoolean(IS_LOGIN, value) }

    override var userId: Int
        get() = pref.getInt(USER_ID, DEFALULT_USER_ID)
        set(value) = pref.edit { putString(USER_ID, Json.encodeToString(value)) }

    override fun clear() {
        pref.edit { clear() }
    }

    companion object {
        const val FILE_NAME = "soptDataStore"
        const val IS_LOGIN = "isLogin"
        const val USER_ID = "user_ID"
        const val DEFALULT_USER_ID = 1
    }
}