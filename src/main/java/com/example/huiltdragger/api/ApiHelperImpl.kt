package com.example.huiltdragger.api

import com.example.huiltdragger.model.EmployeeResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(

    private  val apiService: ApiService):ApiHelper {

    override suspend fun getEmployees(): Response<EmployeeResponse> = apiService.getEmployees()
}