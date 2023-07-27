package com.practical.duplextask.presentation.view_model


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practical.duplextask.domain.use_case.GetUserDataUseCase
import com.practical.duplextask.domain.model.UserItemsData
import com.practical.duplextask.domain.use_case.AddUserDataUseCase
import com.tootl.screensaver.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserDataUseCase: GetUserDataUseCase,
    private val addUserDataUseCase: AddUserDataUseCase
) : ViewModel() {

    var userList by mutableStateOf<MutableList<UserItemsData>?>(null)
    var user by mutableStateOf<UserItemsData?>(null)

    var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var email by mutableStateOf("")
    var mobileNumber by mutableStateOf("")
    var addUserScreenToHomeScreen by mutableStateOf(false)
    var showDialog by mutableStateOf(false)

    init {
        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch {
            getUserDataUseCase().onEach { resource ->
                when (resource) {
                    is Resource.Success -> {
                        userList = resource.data as MutableList<UserItemsData>?
                    }

                    is Resource.Error -> {
                    }

                    is Resource.Loading -> {
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun addUserData(data: UserItemsData) {
        viewModelScope.launch {
            addUserDataUseCase(data)
            userList?.add(data)
        }
    }


    fun onChangeFirstName(newValue: String) {
        firstName = newValue
    }

    fun onChangeLastName(newValue: String) {
        lastName = newValue
    }

    fun onChangeEmail(newValue: String) {
        email = newValue
    }

    fun onChangeNumber(newValue: String) {
        mobileNumber = newValue
    }

    fun onClickedSave() {
        if(isDataValid()){
            addUserData(makeUserData())
            clearTextData()
        }


    }

    fun isDataValid() : Boolean{

        return firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank() && mobileNumber.isNotBlank()

    }

    private fun clearTextData() {
        onChangeFirstName("")
        onChangeLastName("")
        onChangeEmail("")
        onChangeNumber("")
        addUserScreenToHomeScreen=true
    }

    private fun makeUserData(): UserItemsData {
        return UserItemsData(
            firstName = firstName,
            lastName = lastName,
            email = email,
            mobileNumber = mobileNumber,
        )

    }
}

