package com.app.mviarch

import android.app.Application
import com.app.mviarch.di.ciceroneModule
import com.app.mviarch.di.navigationModule
import com.app.mviarch.screens.home.di.homeModule
import com.app.mviarch.screens.page.di.pageModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidLogger(Level.ERROR)
			androidContext(this@App)

			modules(
				ciceroneModule,
				navigationModule,
				homeModule,
				pageModule,
			)
		}
	}
}