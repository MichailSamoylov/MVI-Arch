package com.app.mviarch.screens.home.domain.usecase

import com.app.mviarch.screens.home.domain.repository.HomeRepository
import com.app.mviarch.screens.home.domain.entity.PokemonEntity

class GetPokemonListUseCase(private val repository: HomeRepository) {

	suspend operator fun invoke(itemIndex: Int): PokemonEntity = repository.get(itemIndex)
}