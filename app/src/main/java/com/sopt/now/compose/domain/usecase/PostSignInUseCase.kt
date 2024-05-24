package com.sopt.now.compose.domain.usecase

import com.sopt.now.compose.domain.repository.SoptAuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostSignInUseCase @Inject constructor(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(authenticationId: String, password: String): Result<Int?> =
        soptAuthRepository.postSignIn(authenticationId = authenticationId, password = password)
}