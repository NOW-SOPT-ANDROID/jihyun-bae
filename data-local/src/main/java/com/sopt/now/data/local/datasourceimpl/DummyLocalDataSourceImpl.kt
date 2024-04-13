package com.sopt.now.data.local.datasourceimpl

import android.content.SharedPreferences
import androidx.core.content.edit
import com.sopt.now.data.datasource.local.DummyLocalDataSource
import javax.inject.Inject

class DummyLocalDataSourceImpl
@Inject
constructor(
    private val dataStore: SharedPreferences
) : DummyLocalDataSource {
    override fun setDummyData(dummy: Int) {
        dataStore.edit { putInt(DUMMY, dummy) }
    }

    companion object {
        const val DUMMY = "dummy"
    }
}
