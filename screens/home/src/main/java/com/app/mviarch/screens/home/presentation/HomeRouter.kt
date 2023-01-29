package com.app.mviarch.screens.home.presentation

interface HomeRouter {

	fun navigateToSearchScreen(pokemonName:String)

	fun navigateBack()
}