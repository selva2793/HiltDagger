package com.example.huiltdragger.repository

import com.example.huiltdragger.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(

    private val apiHelper: ApiHelper) {

    suspend fun getEmployee() = apiHelper.getEmployees()

}