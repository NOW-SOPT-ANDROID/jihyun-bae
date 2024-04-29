package com.sopt.now.compose.data.datasourceimpl.remote

import com.sopt.now.compose.data.datasource.remote.FakeRepoListRemoteDataSource
import com.sopt.now.compose.data.model.remote.response.ResponseFakeRepoListDto
import com.sopt.now.compose.util.AssetLoader
import kotlinx.serialization.json.Json
import javax.inject.Inject

class FakeRepoListRemoteDataSourceImpl @Inject constructor(
    private val assetLoader: AssetLoader
) : FakeRepoListRemoteDataSource {
    override suspend fun getFakeRepoList(): Array<ResponseFakeRepoListDto> =
        assetLoader.getJsonString(FAKE_REPO_LIST)?.let { jsonString ->
            Json.decodeFromString<Array<ResponseFakeRepoListDto>>(jsonString)
        } ?: emptyArray()

    companion object {
        private const val FAKE_REPO_LIST = "fake_repo_list.json"
    }
}