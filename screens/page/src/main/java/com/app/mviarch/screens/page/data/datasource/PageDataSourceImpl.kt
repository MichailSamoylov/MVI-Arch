package com.app.mviarch.screens.page.data.datasource

import com.app.mviarch.screens.page.data.api.PageApi
import com.app.mviarch.screens.page.data.model.PokemonPageModel

class PageDataSourceImpl(private val api: PageApi) : PageDataSource {

	override suspend fun get(pokemonName:String): PokemonPageModel = api.get(pokemonName)
}