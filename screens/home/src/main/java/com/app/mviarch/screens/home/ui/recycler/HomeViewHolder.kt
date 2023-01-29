package com.app.mviarch.screens.home.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mviarch.screens.home.databinding.ListItemViewBinding
import com.app.mviarch.screens.home.domain.entity.PokemonEntity
import com.squareup.picasso.Picasso

class HomeViewHolder(
	private val binding: ListItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		const val LOADING_NAME = "LOADING"
		const val POKEMON_ICON_HEIGHT = 800
		const val POKEMON_ICON_WIGHT = 800

		fun from(parent: ViewGroup): HomeViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = ListItemViewBinding.inflate(inflater, parent, false)
			return HomeViewHolder(binding)
		}
	}

	fun bind(
		entity: PokemonEntity,
		navigateItem: (nameOfPokemon: String) -> Unit
	) {
		with(binding) {
			if (entity.name == LOADING_NAME) {
				itemContent.visibility = View.INVISIBLE
				itemProgressBar.visibility = View.VISIBLE
			} else {
				itemContent.visibility = View.VISIBLE
				itemProgressBar.visibility = View.GONE
				pokemonName.text = entity.name
				Picasso
					.get()
					.load(entity.sprites.front_default)
					.resize(POKEMON_ICON_WIGHT, POKEMON_ICON_HEIGHT)
					.into(pokemonImage)

				root.setOnClickListener {
					navigateItem(entity.name)
				}
			}
		}
	}
}