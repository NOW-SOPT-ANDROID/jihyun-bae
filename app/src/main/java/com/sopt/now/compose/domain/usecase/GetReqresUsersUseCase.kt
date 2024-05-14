package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.ReqresRepository

class GetReqresUsersUseCase(
    private val reqresRepository: ReqresRepository
) {
    suspend operator fun invoke(page: Int) =
        reqresRepository.getReqresUsers(page = page)
}