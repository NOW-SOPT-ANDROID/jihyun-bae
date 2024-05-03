package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.ReqresUserEntity
import com.sopt.now.domain.repository.ReqresRepository

class GetReqresListUsersUseCase(
    private val reqresRepository: ReqresRepository
) {
    suspend operator fun invoke(page: Int) =
        reqresRepository.getReqresListUsers(page = page)
}