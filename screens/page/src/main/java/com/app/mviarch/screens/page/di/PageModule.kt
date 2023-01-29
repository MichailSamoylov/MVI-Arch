package com.app.mviarch.screens.page.di

import com.app.mviarch.screens.page.data.api.PageApi
import com.app.mviarch.screens.page.data.api.PageRepositoryImpl
import com.app.mviarch.screens.page.data.datasource.PageDataSource
import com.app.mviarch.screens.page.data.datasource.PageDataSourceImpl
import com.app.mviarch.screens.page.domain.repository.PageRepository
import com.app.mviarch.screens.page.domain.usecase.PokemonPageUseCase
import com.app.mviarch.screens.page.presentation.PageViewModel
import com.app.myapplication.network.retrofit.apiProvide
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pageModule = module {
	factory<PageDataSource> { PageDataSourceImpl(get()) }
	factory<PageRepository> { PageRepositoryImpl(get()) }
	factory { PokemonPageUseCase(get()) }
	factory<PageApi> { apiProvide().create(PageApi::class.java) }
	viewModel {
		PageViewModel(
			router = get(),
			useCase = get()
		)
	}
}