package com.app.mviarch.screens.page.domain.repository

import com.app.mviarch.screens.page.domain.entity.PokemonPageEntity

interface PageRepository {

	suspend fun get(nameOfPokemon:String): PokemonPageEntity
}