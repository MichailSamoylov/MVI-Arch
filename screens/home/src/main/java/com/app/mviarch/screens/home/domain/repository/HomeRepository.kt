package com.app.mviarch.screens.home.domain.repository

import com.app.mviarch.screens.home.domain.entity.PokemonEntity

interface HomeRepository {

	suspend fun get(itemIndex:Int): PokemonEntity
}