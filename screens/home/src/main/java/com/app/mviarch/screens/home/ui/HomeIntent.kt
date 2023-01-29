package com.app.mviarch.screens.home.ui

import com.app.mviarch.components.mvi.ui.ViewIntent

sealed class HomeIntent : ViewIntent {

	object LoadPokemonList : HomeIntent()

	object UpdatePokemonList : HomeIntent()

	data class ClickByListItem(
		val itemName: String
	) : HomeIntent()
}
