package fr.univavignon.pokedex.api.implementation;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(final String name,
                                        final Team team,
                                        final IPokedexFactory pokedexFactory) {

        return new PokemonTrainer(name, team,
                pokedexFactory.createPokedex(
                        new PokemonMetadataProvider(),
                        new PokemonFactory()));
    }
}
