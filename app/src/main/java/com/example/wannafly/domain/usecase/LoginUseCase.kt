package com.example.wannafly.domain.usecase

import com.example.wannafly.domain.mapper.LoginMapper
import com.example.wannafly.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface LoginUseCase {
    fun execute(): Flow<LoginState>
}

class LoginUseCaseImpl(
    private val repository: Repository,
    private val mapper: LoginMapper,
    private val coroutineDispatcher: CoroutineDispatcher
) : LoginUseCase {
    override fun execute() : Flow<LoginState> = flow {
        TODO("Not yet implemented")
    }
}

sealed class LoginState {
    // TODO: implement states of request (Loading, Success, Error...)
}

