package com.app.mviarch.navigation

import com.app.mviarch.screens.home.presentation.HomeRouter
import com.app.mviarch.screens.page.getPageScreen
import com.github.terrakok.cicerone.Router

class HomeRouterImpl(private val router:Router): HomeRouter {

	override fun navigateToSearchScreen(pokemonName:String) {
		router.navigateTo(getPageScreen(pokemonName))
	}

	override fun navigateBack() {
		router.exit()
	}
}