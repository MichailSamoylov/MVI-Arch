package com.app.mviarch.screens.page.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app.mviarch.components.extension.addBackPressedListener
import com.app.mviarch.screens.page.R
import com.app.mviarch.screens.page.databinding.FragmentPageBinding
import com.app.mviarch.screens.page.presentation.PageState
import com.app.mviarch.screens.page.presentation.PageViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

const val NUMBER_POKEMON_KEY = "NAME_POKEMON_KEY"
var Bundle.namePokemon: String
	get() = this.getString(NUMBER_POKEMON_KEY) ?: ""
	set(value) = this.putString(NUMBER_POKEMON_KEY, value)

class PageFragment : Fragment() {

	companion object {

		fun newInstance(nameOfPokemon: String) =
			PageFragment()
				.apply {
					val bundle = Bundle()
					bundle.namePokemon = nameOfPokemon
					arguments = bundle
				}
	}

	private val viewModel: PageViewModel by viewModel()

	private lateinit var binding: FragmentPageBinding

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		super.onCreateView(inflater, container, savedInstanceState)
		binding = FragmentPageBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setObservers()
		setListeners()
		arguments?.namePokemon?.let {pokemonName ->
			viewModel.sendIntent(PageIntent.LoadPokemonParameters(pokemonName))
		}
	}

	private fun setObservers(){
		viewModel.state.observe(viewLifecycleOwner, ::handleState)
	}

	private fun setListeners(){
		addBackPressedListener { viewModel.sendIntent(PageIntent.NavigateBack) }
	}

	private fun handleState(state: PageState) {
		when (state) {
			is PageState.Initial -> Unit
			is PageState.Loading -> renderLoading()
			is PageState.Content -> renderContent(state)
			is PageState.Error   -> renderError()
		}
	}

	private fun renderLoading() {
		with(binding) {
			progressBar.visibility = View.VISIBLE
			content.visibility = View.GONE
		}
	}

	private fun renderError() {
		Toast.makeText(requireContext(), getString(R.string.pokemon_page_error_message), Toast.LENGTH_LONG).show()
	}

	@SuppressLint("SetTextI18n")
	private fun renderContent(state: PageState.Content) {
		with(binding) {
			progressBar.visibility = View.GONE
			content.visibility = View.VISIBLE

			name.text = state.entity.name
			type.text = "${getString(R.string.pokemon_page_type_text)} ${state.entity.type}"
			wight.text = "${getString(R.string.pokemon_page_wight_text)} ${state.entity.weight}"
			height.text = "${getString(R.string.pokemon_page_height_text)} ${state.entity.height}"
			Picasso
				.get()
				.load(state.entity.sprites.front_default)
				.resize(600, 600)
				.into(icon)
		}
	}
}