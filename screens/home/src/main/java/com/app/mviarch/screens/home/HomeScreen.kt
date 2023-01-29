package com.app.mviarch.screens.home

import com.app.mviarch.screens.home.ui.HomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getStartScreen() = FragmentScreen { HomeFragment.newInstance() }