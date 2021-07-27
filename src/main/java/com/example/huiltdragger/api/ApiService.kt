package com.example.huiltdragger.api

import com.example.huiltdragger.model.EmployeeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


    @GET("employees")
    suspend fun getEmployees():Response<EmployeeResponse>
}