package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.ReqresRepository

class GetReqresListUsersUseCase(
    private val reqresRepository: ReqresRepository
) {
    suspend operator fun invoke(page: Int) =
        reqresRepository.getReqresListUsers(page = page)
}