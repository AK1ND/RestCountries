package com.example.countryapp


import com.example.countryapp.model.ModelItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("all")
    fun getCountryList(): Call<List<ModelItem>>

}