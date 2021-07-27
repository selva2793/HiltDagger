package com.example.huiltdragger.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.huiltdragger.model.EmployeeResponse
import com.example.huiltdragger.repository.MainRepository
import com.example.huiltdragger.utils.NetworkHelper
import com.example.huiltdragger.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
private val mainRepository: MainRepository,
private val networkHelper: NetworkHelper
):ViewModel(){

    private val _res = MutableLiveData<Resource<EmployeeResponse>>()

    val res:LiveData<Resource<EmployeeResponse>> get() = _res

    init {
        getEmployees()
    }

    private fun getEmployees() = viewModelScope.launch {

        _res.postValue(Resource.loading(null))
        if (networkHelper.isNetworkConnected()) {

            mainRepository.getEmployee()?.let {
                if(it.isSuccessful){
                    _res.postValue(Resource.success(it.body()))
                }
                else{
                    _res.postValue(Resource.error(it.errorBody().toString(),null))
                }
            }
        }else{
            _res.postValue(Resource.error("No internet connection", null))
        }

    }



}