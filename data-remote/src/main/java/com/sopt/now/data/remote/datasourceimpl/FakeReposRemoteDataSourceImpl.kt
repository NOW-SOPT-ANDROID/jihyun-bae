package com.sopt.now.data.remote.datasourceimpl

import com.sopt.now.data.remote.datasource.FakeReposRemoteDataSource
import com.sopt.now.data.remote.model.response.ResponseFakeReposDto
import com.sopt.now.data.remote.util.AssetLoader
import kotlinx.serialization.json.Json
import javax.inject.Inject

class FakeReposRemoteDataSourceImpl @Inject constructor(
    private val assetLoader: AssetLoader
) : FakeReposRemoteDataSource {
    override suspend fun getFakeRepos(): Array<ResponseFakeReposDto> =
        assetLoader.getJsonString(FAKE_REPO_LIST)?.let { jsonString ->
            Json.decodeFromString<Array<ResponseFakeReposDto>>(jsonString)
        } ?: emptyArray()

    companion object {
        private const val FAKE_REPO_LIST = "fake_repo_list.json"
    }
}