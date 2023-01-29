package com.app.mviarch.screens.home.domain.entity

data class PokemonEntity(
	val name: String,
	val sprites: Sprites
)

data class Sprites(
	val front_default: String
)
