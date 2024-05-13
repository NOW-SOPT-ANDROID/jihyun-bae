package com.sopt.now.domain.usecase

import com.sopt.now.domain.model.SoptUserModel
import com.sopt.now.domain.repository.SoptAuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostSignUpUseCase @Inject constructor(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(soptUserModel: SoptUserModel): Result<String> =
        soptAuthRepository.postSignUp(soptUserModel = soptUserModel)
}