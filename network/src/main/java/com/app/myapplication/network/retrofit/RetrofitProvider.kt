package com.app.myapplication.network.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InternetUrl {

	const val BASE_URL = "https://pokeapi.co/api/v2/"
}

fun apiProvide(): Retrofit = Retrofit.Builder().apply {
	baseUrl(InternetUrl.BASE_URL)
	addConverterFactory(GsonConverterFactory.create())
}.build()