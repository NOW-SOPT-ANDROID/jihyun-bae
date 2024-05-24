package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.ReqresUserModel
import com.sopt.now.compose.domain.repository.ReqresRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetReqresUsersUseCase @Inject constructor(
    private val reqresRepository: ReqresRepository
) {
    suspend operator fun invoke(page: Int): Result<List<ReqresUserModel>> =
        reqresRepository.getReqresUsers(page = page)
}