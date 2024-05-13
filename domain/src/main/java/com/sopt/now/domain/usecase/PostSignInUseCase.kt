package com.sopt.now.domain.usecase

import com.sopt.now.domain.repository.SoptAuthRepository

class PostSignInUseCase(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(authenticationId: String, password: String) =
        soptAuthRepository.postSignIn(authenticationId = authenticationId, password = password)
}