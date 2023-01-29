package com.app.mviarch.screens.home.di

import com.app.myapplication.network.retrofit.apiProvide
import com.app.mviarch.screens.home.data.api.HomeApi
import com.app.mviarch.screens.home.data.datasource.HomeDataSource
import com.app.mviarch.screens.home.data.datasource.HomeDataSourceImpl
import com.app.mviarch.screens.home.data.repository.HomeRepositoryImpl
import com.app.mviarch.screens.home.domain.usecase.GetPokemonListUseCase
import com.app.mviarch.screens.home.domain.repository.HomeRepository
import com.app.mviarch.screens.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
	factory<HomeRepository> { HomeRepositoryImpl(dataSource = get()) }
	factory<HomeDataSource> { HomeDataSourceImpl(api = get()) }
	factory { GetPokemonListUseCase(repository = get()) }
	factory<HomeApi> { apiProvide().create(HomeApi::class.java) }

	viewModel {
		HomeViewModel(
			get(),
			get()
		)
	}
}