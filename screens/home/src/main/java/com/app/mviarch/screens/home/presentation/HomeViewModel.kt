package com.app.mviarch.screens.home.presentation

import androidx.lifecycle.viewModelScope
import com.app.mviarch.components.mvi.presentation.BaseViewModel
import com.app.mviarch.screens.home.domain.usecase.GetPokemonListUseCase
import com.app.mviarch.screens.home.domain.entity.PokemonEntity
import com.app.mviarch.screens.home.domain.entity.Sprites
import com.app.mviarch.screens.home.ui.HomeIntent
import com.app.mviarch.screens.home.ui.recycler.HomeViewHolder
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class HomeViewModel(
	private val router: HomeRouter,
	private val useCase: GetPokemonListUseCase
) : BaseViewModel<HomeIntent, HomeAction, HomeState>() {

	private companion object {

		const val START_POKEMON_INDEX = 1
		const val COUNT_POKEMON_FOR_UPDATE = 15
	}

	init {
		_state.value = HomeState.Initial
	}

	private val errorHandler = CoroutineExceptionHandler { _, _ ->
		_state.postValue(HomeState.Error)
	}

	override fun intentToAction(intent: HomeIntent): HomeAction =
		when (intent) {
			is HomeIntent.ClickByListItem -> HomeAction.NavigateToItem(intent.itemName)
			HomeIntent.LoadPokemonList    -> HomeAction.LoadPokemonList
			HomeIntent.UpdatePokemonList  -> HomeAction.UpdateList
		}

	override fun handleAction(action: HomeAction) {
		when (action) {
			HomeAction.LoadPokemonList   -> loadPokemonList()
			is HomeAction.NavigateToItem -> navigateToItem(action.itemName)
			HomeAction.UpdateList        -> updateList()
		}
	}

	private fun loadPokemonList() {
		val tempState = _state.value as? HomeState.Content
		if(tempState == null){
			_state.value = HomeState.Loading
			viewModelScope.launch(errorHandler) {
				val pokemonList = mutableListOf<PokemonEntity>()
				pokemonList.addPokemonsInRange(START_POKEMON_INDEX..COUNT_POKEMON_FOR_UPDATE)
				_state.value = HomeState.Content(pokemonList)
			}
		}
	}

	private fun updateList() {
		val tempState = _state.value as? HomeState.Content ?: return
		viewModelScope.launch(errorHandler) {
			val startRange = tempState.listOfPokemon.size + START_POKEMON_INDEX
			val endRange = tempState.listOfPokemon.size + COUNT_POKEMON_FOR_UPDATE
			val pokemonList = tempState.listOfPokemon.toMutableList()

			pokemonList.addLoadItem()

			pokemonList.addPokemonsInRange(startRange..endRange)

			_state.value = HomeState.Content(pokemonList)
		}
	}

	private suspend fun MutableList<PokemonEntity>.addPokemonsInRange(range: IntRange) {
		for (i in range) {
			this.add(useCase(i))
		}
	}

	private fun MutableList<PokemonEntity>.addLoadItem() {
		this.add(
			PokemonEntity(
				name = HomeViewHolder.LOADING_NAME,
				sprites = Sprites(front_default = "")
			)
		)
		_state.value = HomeState.Content(this)
		this.removeLast()
	}

	private fun navigateToItem(nameOfPokemon: String) {
		router.navigateToSearchScreen(nameOfPokemon)
	}

	private fun navigateBack() {
		router.navigateBack()
	}
}