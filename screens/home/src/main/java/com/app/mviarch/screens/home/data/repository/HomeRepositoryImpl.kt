package com.app.mviarch.screens.home.data.repository

import com.app.mviarch.screens.home.data.datasource.HomeDataSource
import com.app.mviarch.screens.home.domain.repository.HomeRepository
import com.app.mviarch.screens.home.domain.entity.PokemonEntity

class HomeRepositoryImpl(private val dataSource: HomeDataSource) : HomeRepository {

	override suspend fun get(itemIndex: Int): PokemonEntity = dataSource.get(itemIndex)
}