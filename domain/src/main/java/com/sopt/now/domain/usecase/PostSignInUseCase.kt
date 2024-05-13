package com.sopt.now.domain.usecase

import com.sopt.now.domain.repository.SoptAuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostSignInUseCase @Inject constructor(
    private val soptAuthRepository: SoptAuthRepository
) {
    suspend operator fun invoke(authenticationId: String, password: String): Result<Int?> =
        soptAuthRepository.postSignIn(authenticationId = authenticationId, password = password)
}