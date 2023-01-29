package com.app.mviarch.navigation

import com.app.mviarch.screens.page.presentation.PageRouter
import com.github.terrakok.cicerone.Router

class PageRouterImpl(private val router: Router):PageRouter {

	override fun navigateBack() {
		router.exit()
	}
}