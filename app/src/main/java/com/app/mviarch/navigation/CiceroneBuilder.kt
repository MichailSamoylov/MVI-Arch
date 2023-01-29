package com.app.mviarch.navigation

import com.app.mviarch.screens.home.getStartScreen
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

fun buildCicerone(): Cicerone<Router> =
	Cicerone.create().apply {
		router.newRootScreen(getStartScreen())
	}