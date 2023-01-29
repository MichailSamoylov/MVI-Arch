package com.app.mviarch.screens.home.data.datasource

import com.app.mviarch.screens.home.data.api.HomeApi
import com.app.mviarch.screens.home.domain.entity.PokemonEntity

class HomeDataSourceImpl(private val api: HomeApi): HomeDataSource {

	override suspend fun get(itemIndex: Int): PokemonEntity = api.get(itemIndex)
}