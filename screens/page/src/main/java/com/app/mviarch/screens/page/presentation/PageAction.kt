package com.app.mviarch.screens.page.presentation

import com.app.mviarch.components.mvi.presentation.ViewAction

sealed class PageAction:ViewAction{
	data class LoadParameters(
		val pokemonName:String
	):PageAction()

	object NavigateBack:PageAction()
}
