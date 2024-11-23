package com.example.wannafly.ui.login.uistate

sealed class LoginUIState {
    // TODO: states of screen (Loading, Success, Error...)
}

data class SignInState(
    val isSignInSuccess: Boolean = false,
    val signInError: String? = null
)