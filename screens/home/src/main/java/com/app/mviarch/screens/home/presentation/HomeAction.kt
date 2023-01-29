package com.app.mviarch.screens.home.presentation

import com.app.mviarch.components.mvi.presentation.ViewAction

sealed class HomeAction : ViewAction {

	data class NavigateToItem(
		val itemName: String
	) : HomeAction()

	object LoadPokemonList : HomeAction()

	object UpdateList : HomeAction()
}
