package com.app.mviarch.screens.page.data.datasource

import com.app.mviarch.screens.page.data.model.PokemonPageModel

interface PageDataSource {

	suspend fun get(pokemonName:String): PokemonPageModel
}