package com.app.mviarch.screens.page.presentation

import androidx.lifecycle.viewModelScope
import com.app.mviarch.components.mvi.presentation.BaseViewModel
import com.app.mviarch.screens.page.domain.usecase.PokemonPageUseCase
import com.app.mviarch.screens.page.ui.PageIntent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class PageViewModel(
	private val router: PageRouter,
	private val useCase: PokemonPageUseCase
) : BaseViewModel<PageIntent, PageAction, PageState>() {

	init {
		_state.value = PageState.Initial
	}

	private val errorHandler = CoroutineExceptionHandler { _, throwable ->
		_state.value = PageState.Error
	}

	override fun intentToAction(intent: PageIntent): PageAction =
		when(intent){
			is PageIntent.LoadPokemonParameters -> PageAction.LoadParameters(intent.pokemonName)
			PageIntent.NavigateBack             -> PageAction.NavigateBack
		}

	override fun handleAction(action: PageAction) {
		when(action){
			is PageAction.LoadParameters -> loadPokemonParameters(action.pokemonName)
			PageAction.NavigateBack      -> navigateBack()
		}
	}

	private fun loadPokemonParameters(pokemonName:String){
		_state.value = PageState.Loading
		viewModelScope.launch(errorHandler) {
			_state.value = PageState.Content(
				useCase.invoke(pokemonName)
			)
		}
	}

	private fun navigateBack() {
		router.navigateBack()
	}
}