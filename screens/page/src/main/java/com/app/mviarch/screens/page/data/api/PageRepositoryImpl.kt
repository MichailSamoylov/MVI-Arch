package com.app.mviarch.screens.page.data.api

import com.app.mviarch.screens.page.data.datasource.PageDataSource
import com.app.mviarch.screens.page.data.mapper.toEntity
import com.app.mviarch.screens.page.domain.entity.PokemonPageEntity
import com.app.mviarch.screens.page.domain.repository.PageRepository

class PageRepositoryImpl(private val dataSource: PageDataSource):PageRepository {

	override suspend fun get(nameOfPokemon: String): PokemonPageEntity = dataSource.get(nameOfPokemon).toEntity()
}