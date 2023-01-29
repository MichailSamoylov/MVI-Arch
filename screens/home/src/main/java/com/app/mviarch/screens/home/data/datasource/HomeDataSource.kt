package com.app.mviarch.screens.home.data.datasource

import com.app.mviarch.screens.home.domain.entity.PokemonEntity

interface HomeDataSource {

	suspend fun get(itemIndex: Int): PokemonEntity
}