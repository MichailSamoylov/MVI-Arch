package com.app.mviarch.screens.page.data.model

import com.google.gson.annotations.SerializedName

data class PokemonPageModel(
	@SerializedName("name")
	val name:String,
	@SerializedName("types")
	val types:List<Types>,
	@SerializedName("weight")
	val weight:String,
	@SerializedName("height")
	val height:String,
	@SerializedName("sprites")
	val sprites: SpritesModel
)

data class SpritesModel(
	@SerializedName("front_default")
	val front_default: String
)

data class Types(
	@SerializedName("type")
	val type: Type
)

data class Type(
	@SerializedName("name")
	val name: String
)