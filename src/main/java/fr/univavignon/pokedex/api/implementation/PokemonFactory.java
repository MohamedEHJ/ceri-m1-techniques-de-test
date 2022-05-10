package fr.univavignon.pokedex.api.implementation;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.Objects;

public class PokemonFactory implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata pokemonMetadata = null;

        try {
            pokemonMetadata = new PokemonMetadataProvider().getPokemonMetadata(index);
        } catch (PokedexException e) {
            System.out.println(e.getMessage());
        }

        double iv = 56.0;
        if (index == 133) {
            iv = 100.0;
        }

        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(),
                pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
    }
}
