package com.app.mviarch.screens.home.presentation

import com.app.mviarch.components.mvi.presentation.ViewState
import com.app.mviarch.screens.home.domain.entity.PokemonEntity

sealed class HomeState : ViewState {

	object Initial : HomeState()

	object Loading : HomeState()

	data class Content(
		val listOfPokemon: List<PokemonEntity>
	) : HomeState()

	object Error : HomeState()


}
