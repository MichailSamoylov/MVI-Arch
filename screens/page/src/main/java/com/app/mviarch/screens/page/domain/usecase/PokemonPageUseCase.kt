package com.app.mviarch.screens.page.domain.usecase

import com.app.mviarch.screens.page.domain.entity.PokemonPageEntity
import com.app.mviarch.screens.page.domain.repository.PageRepository

class PokemonPageUseCase(private val repository: PageRepository) {

	suspend operator fun invoke(nameOfPokemon: String): PokemonPageEntity =
		repository.get(nameOfPokemon)
}