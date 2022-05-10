package fr.univavignon.pokedex.api.implementation;

import fr.univavignon.pokedex.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private List<Pokemon> pokemonList;
    IPokemonMetadataProvider metadataProvider = null;
    IPokemonFactory pokemonFactory = null;


    public Pokedex() {
        this.pokemonList = new ArrayList<>();
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonList = new ArrayList<>();
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return pokemonList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return this.size();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id > this.size() - 1)
            throw new PokedexException("Id not in pokedex");

        return pokemonList.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemonList);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> pokemonListSorted = new ArrayList<>(pokemonList);
        pokemonListSorted.sort(order);
        return Collections.unmodifiableList(pokemonListSorted);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
