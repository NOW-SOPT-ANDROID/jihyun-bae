package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.ReqresUserModel
import com.sopt.now.domain.repository.ReqresRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetReqresListUsersUseCase @Inject constructor(
    private val reqresRepository: ReqresRepository
) {
    suspend operator fun invoke(page: Int): Result<List<ReqresUserModel>> =
        reqresRepository.getReqresListUsers(page = page)
}