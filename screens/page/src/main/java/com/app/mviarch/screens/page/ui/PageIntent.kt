package com.app.mviarch.screens.page.ui

import com.app.mviarch.components.mvi.ui.ViewIntent

sealed class PageIntent : ViewIntent {
	data class LoadPokemonParameters(
		val pokemonName: String
	) : PageIntent()

	object NavigateBack:PageIntent()
}
