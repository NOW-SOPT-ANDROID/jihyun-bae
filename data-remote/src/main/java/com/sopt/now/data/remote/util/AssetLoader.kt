package com.sopt.now.data.remote.util

import android.content.Context


class AssetLoader(private val context: Context) {
    fun getJsonString(fileName: String): String? {
        return runCatching {
            loadAsset(fileName)
        }.getOrNull()
    }

    private fun loadAsset(fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            ByteArray(inputStream.available()).let { byteArray ->
                inputStream.read(byteArray)
                String(byteArray)
            }
        }
    }
}