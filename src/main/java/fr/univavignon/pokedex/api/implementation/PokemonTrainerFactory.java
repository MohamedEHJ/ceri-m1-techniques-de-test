package fr.univavignon.pokedex.api.implementation;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import fr.univavignon.pokedex.api.implementation.PokemonFactory;
import fr.univavignon.pokedex.api.implementation.PokemonMetadataProvider;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory()));
    }
}
