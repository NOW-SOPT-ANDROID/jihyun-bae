package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.model.SoptUserModel
import com.sopt.now.compose.domain.repository.SoptAuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostSignUpUseCase @Inject constructor(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(soptUserModel: SoptUserModel): Result<String> =
        soptAuthRepository.postSignUp(soptUserModel = soptUserModel)
}