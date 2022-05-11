package fr.univavignon.pokedex.api;

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
