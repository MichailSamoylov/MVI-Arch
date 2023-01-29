package com.app.mviarch.screens.page.data.api

import com.app.mviarch.screens.page.data.model.PokemonPageModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PageApi {

	@GET("pokemon/{name}")
	suspend fun get(@Path("name") name: String): PokemonPageModel
}