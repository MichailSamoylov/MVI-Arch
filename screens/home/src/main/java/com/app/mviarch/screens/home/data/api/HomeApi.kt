package com.app.mviarch.screens.home.data.api

import com.app.mviarch.screens.home.domain.entity.PokemonEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApi {
	@GET("pokemon/{itemIndex}")
	suspend fun get(@Path("itemIndex") itemIndex:Int): PokemonEntity
}