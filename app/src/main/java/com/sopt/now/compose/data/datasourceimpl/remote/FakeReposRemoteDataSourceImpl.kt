package com.sopt.now.compose.data.datasourceimpl.remote

import com.sopt.now.compose.data.datasource.remote.FakeReposRemoteDataSource
import com.sopt.now.compose.data.model.remote.response.ResponseFakeReposDto
import com.sopt.now.compose.util.AssetLoader
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