package com.example.wannafly.ui.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wannafly.data.remote.response.SignInResultResponse
import com.example.wannafly.ui.login.uistate.SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    fun onSignInResult(result: SignInResultResponse) {
        _state.update { it.copy(
            isSignInSuccess = result.data != null,
            signInError = result.errorMessage
        ) }
    }

    fun resetState() {
        _state.update { SignInState() }
    }
}