package com.app.mviarch.di

import com.app.mviarch.navigation.HomeRouterImpl
import com.app.mviarch.navigation.PageRouterImpl
import com.app.mviarch.screens.home.presentation.HomeRouter
import com.app.mviarch.screens.page.presentation.PageRouter
import org.koin.dsl.module

val navigationModule = module {
	factory<HomeRouter> { HomeRouterImpl(get()) }
	factory<PageRouter> { PageRouterImpl(get()) }
}