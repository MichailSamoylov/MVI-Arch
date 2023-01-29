package com.app.mviarch.screens.page.data.mapper

import com.app.mviarch.screens.page.data.model.PokemonPageModel
import com.app.mviarch.screens.page.domain.entity.PokemonPageEntity
import com.app.mviarch.screens.page.domain.entity.Sprites

fun PokemonPageModel.toEntity() =
	PokemonPageEntity(
		name = name,
		type = this.types.last().type.name,
		weight= weight,
		height = height,
		sprites = Sprites(sprites.front_default)
	)