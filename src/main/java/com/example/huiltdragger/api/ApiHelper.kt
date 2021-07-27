package com.example.huiltdragger.api

import com.example.huiltdragger.model.EmployeeResponse
import retrofit2.Response

interface ApiHelper {

    suspend fun getEmployees():Response<EmployeeResponse>
}