package com.example.pokedex.scene.pokemon_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.pokedex.R
import com.example.pokedex.infra.pokeapi.PokeApi

class PokemonListFragment : Fragment() {

    companion object {
        fun newInstance() = PokemonListFragment()
    }

    private lateinit var viewModel: PokemonListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.pokemon_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            Log.d("PokemonListFragment", PokeApi.retrofitService.getPokemon().toString())

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PokemonListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}