package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.ReqresUserModel
import com.sopt.now.compose.domain.repository.ReqresRepository

class GetReqresUsersUseCase(
    private val reqresRepository: ReqresRepository
) {
    suspend operator fun invoke(page: Int): Result<List<ReqresUserModel>> =
        reqresRepository.getReqresUsers(page = page)
}