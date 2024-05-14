package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.SoptUserModel
import com.sopt.now.compose.domain.repository.SoptAuthRepository

class PostSignUpUseCase(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(soptUserModel: SoptUserModel): Result<String> =
        soptAuthRepository.postSignUp(soptUserModel = soptUserModel)
}