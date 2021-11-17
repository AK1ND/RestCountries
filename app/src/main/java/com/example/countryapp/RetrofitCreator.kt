package com.example.countryapp

import com.example.countryapp.Const.baseURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitCreator {

    fun getRetrofit(): RetrofitService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL)
            .build().create(RetrofitService::class.java)

    }


}