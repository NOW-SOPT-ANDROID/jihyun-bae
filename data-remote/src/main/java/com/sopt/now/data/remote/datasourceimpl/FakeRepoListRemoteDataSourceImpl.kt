package com.sopt.now.data.remote.datasourceimpl

import com.sopt.now.data.remote.datasource.FakeRepoListRemoteDataSource
import com.sopt.now.data.remote.model.response.ResponseFakeRepoListDto
import com.sopt.now.data.remote.util.AssetLoader
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