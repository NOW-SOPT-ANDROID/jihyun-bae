package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.SoptAuthRepository

class PostSignInUseCase(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(authenticationId: String, password: String) =
        soptAuthRepository.postSignIn(authenticationId = authenticationId, password = password)
}