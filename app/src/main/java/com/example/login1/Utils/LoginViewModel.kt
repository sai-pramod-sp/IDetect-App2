package com.example.login1.Utils

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.rememberNavController
import com.example.login1.data_source.DetailsDatabases
import com.example.login1.use_cases.DataUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataUseCases: DataUseCases
): ViewModel() {

    private val loginUiState  = mutableStateOf(LoginUiState())

    val isValidationPassed = mutableStateOf(false)

    fun onEvent(event: UiEvent){
        when(event){
            is UiEvent.EnteredEmail -> {
                viewModelScope.launch {
                    loginUiState.value = loginUiState.value.copy(
                        email = event.email
                    )
                }
            }
            is UiEvent.EnteredPassword -> {
                viewModelScope.launch {
                    loginUiState.value = loginUiState.value.copy(
                        password =  event.password
                    )
                    val isEnabled = dataUseCases.validDetails(loginUiState.value.email, loginUiState.value.password)
                    isValidationPassed.value = isEnabled
                }
            }

            else -> {

            }
        }
    }


}