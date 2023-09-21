package com.example.login1.Utils

import android.util.Log
import android.widget.Toast
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login1.data_source.Details
import com.example.login1.use_cases.DataUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val dataUseCases: DataUseCases
): ViewModel() {


    val registrationUiState = mutableStateOf(RegistrationUiState())

    fun onEvent(event: UiEvent){
        when(event){
            is UiEvent.EnteredName -> {
                registrationUiState.value = registrationUiState.value.copy(
                    firstName = event.firstName
                )
            }
            is UiEvent.EnteredLastName -> {
                registrationUiState.value = registrationUiState.value.copy(
                    lastName = event.lastName
                )
            }
            is UiEvent.EnteredEmail -> {
                registrationUiState.value = registrationUiState.value.copy(
                    email = event.email
                )
            }
            is UiEvent.EnteredPassword -> {
                registrationUiState.value = registrationUiState.value.copy(
                    password = event.password
                )
            }
            is UiEvent.RegisterButtonClicked -> {
                if(validation()){
                    viewModelScope.launch {
                        dataUseCases.insertDetails(
                            Details(firstname = registrationUiState.value.firstName,
                                lastName = registrationUiState.value.lastName,
                                email =  registrationUiState.value.email,
                                password = registrationUiState.value.password)
                        )
                    }

                    Log.d("Updating details", "Done")
                }else{
                    Log.d("Updating details", "Not done")
                }
            }

            else -> {
                Log.d("RegistrationViewModel", "NotValid")
            }
        }
    }

    fun validation(): Boolean{
        Log.d("Details", registrationUiState.value.password)
        val password = registrationUiState.value.password
//        return (password.matches(Regex("[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]"))) &&
//                (password.matches(Regex(".*[A-Z].*"))) &&
//                (password.matches(Regex(".{6,}")))
        return password.length > 2


    }
}