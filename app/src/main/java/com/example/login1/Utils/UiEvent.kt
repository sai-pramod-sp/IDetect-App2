package com.example.login1.Utils

sealed class UiEvent{

    data class EnteredName(val firstName: String) : UiEvent()
    data class EnteredLastName(val lastName: String) : UiEvent()
    data class EnteredEmail(val email: String) : UiEvent()
    data class EnteredPassword(val password: String): UiEvent()

    object RegisterButtonClicked : UiEvent()
    object LoginButtonClicked: UiEvent()

}

