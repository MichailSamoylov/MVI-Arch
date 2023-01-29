package com.app.mviarch.screens.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app.mviarch.components.extension.setOnScrollListener
import com.app.mviarch.screens.home.R
import com.app.mviarch.screens.home.databinding.FragmentHomeBinding
import com.app.mviarch.screens.home.domain.entity.PokemonEntity
import com.app.mviarch.screens.home.presentation.HomeState
import com.app.mviarch.screens.home.presentation.HomeViewModel
import com.app.mviarch.screens.home.ui.recycler.HomeListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

	companion object {

		fun newInstance() = HomeFragment()
	}

	private lateinit var binding: FragmentHomeBinding
	private val viewModel: HomeViewModel by viewModel()
	private val adapter: HomeListAdapter by lazy { HomeListAdapter(::resentItemClickIntent) }

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		super.onCreateView(inflater, container, savedInstanceState)
		binding = FragmentHomeBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setObservers()
		setListeners()
		binding.recycler.adapter = adapter
		viewModel.sendIntent(HomeIntent.LoadPokemonList)
	}

	private fun setObservers() {
		viewModel.state.observe(viewLifecycleOwner, ::handleState)
	}

	private fun setListeners() {
		binding.recycler.setOnScrollListener { viewModel.sendIntent(HomeIntent.UpdatePokemonList) }
	}

	private fun handleState(state: HomeState) {
		when (state) {
			is HomeState.Content -> renderContent(state.listOfPokemon)
			HomeState.Error      -> renderError()
			HomeState.Initial    -> renderInitial()
			HomeState.Loading    -> renderLoading()
		}
	}

	private fun resentItemClickIntent(itemName:String){
		viewModel.sendIntent(HomeIntent.ClickByListItem(itemName))
	}

	private fun renderError() {
		Toast.makeText(requireContext(), getString(R.string.error_message), Toast.LENGTH_LONG).show()
	}

	private fun renderInitial() {
		with(binding) {
			recycler.visibility = View.GONE
			progressBar.visibility = View.VISIBLE
		}
	}

	private fun renderLoading() {
		with(binding) {
			recycler.visibility = View.GONE
			progressBar.visibility = View.VISIBLE
		}
	}

	private fun renderContent(list: List<PokemonEntity>) {
		with(binding) {
			recycler.visibility = View.VISIBLE
			progressBar.visibility = View.GONE
			adapter.submitList(list.toMutableList())
		}
	}
}