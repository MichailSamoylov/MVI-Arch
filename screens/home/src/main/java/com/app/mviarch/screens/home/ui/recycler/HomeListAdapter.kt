package com.app.mviarch.screens.home.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.app.mviarch.screens.home.domain.entity.PokemonEntity

class HomeListAdapter(
	private val navigateToItem: (nameOfPokemon: String) -> Unit
) : ListAdapter<PokemonEntity, HomeViewHolder>(VacationsListDiffCallBack) {

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): HomeViewHolder =
		HomeViewHolder.from(parent)

	override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
		holder.bind(this.getItem(position), navigateToItem)
	}
}

object VacationsListDiffCallBack : DiffUtil.ItemCallback<PokemonEntity>() {

	override fun areItemsTheSame(oldItem: PokemonEntity, newItem: PokemonEntity) =
		oldItem == newItem

	override fun areContentsTheSame(oldItem: PokemonEntity, newItem: PokemonEntity) =
		oldItem.name == newItem.name && oldItem.sprites == newItem.sprites
}