package com.example.pokedex.scene.pokemon_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.databinding.PokemonListFragmentBinding

class PokemonListFragment : Fragment() {

    companion object {
        fun newInstance() = PokemonListFragment()
    }

    private lateinit var viewModel: PokemonListViewModel
    private val adapter = PokemonListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = PokemonListFragmentBinding.inflate(
                inflater,
                container,
                false
        )
        binding.pokemonList.adapter = adapter
        binding.pokemonList.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProvider(this).get(PokemonListViewModel::class.java)
        viewModel.pokemonList.observe(viewLifecycleOwner, {
            adapter.pokemonList = it
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onViewCreated()
    }

}