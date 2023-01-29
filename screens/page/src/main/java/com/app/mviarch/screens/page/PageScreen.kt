package com.app.mviarch.screens.page

import com.app.mviarch.screens.page.ui.PageFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getPageScreen(nameOfPokemon: String) = FragmentScreen { PageFragment.newInstance(nameOfPokemon) }