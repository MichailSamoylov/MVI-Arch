package com.app.mviarch.screens.page.presentation

import com.app.mviarch.components.mvi.presentation.ViewState
import com.app.mviarch.screens.page.domain.entity.PokemonPageEntity

sealed class PageState : ViewState {
	object Initial : PageState()

	object Loading : PageState()

	data class Content(
		val entity: PokemonPageEntity
	) : PageState()

	object Error : PageState()
}