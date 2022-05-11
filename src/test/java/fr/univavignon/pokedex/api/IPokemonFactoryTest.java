package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;

    Pokemon bulbizarre, aquali;

    @Before
    public void setUp() throws Exception {
        pokemonFactory = new PokemonFactory();
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void createPokemon() {
        // Création des pokemons.
        Assert.assertEquals(bulbizarre.getIndex(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIndex());
        Assert.assertEquals(aquali.getIndex(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getIndex());

        Assert.assertEquals(bulbizarre.getName(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getName());
        Assert.assertEquals(aquali.getName(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getName());

        Assert.assertNull(pokemonFactory.createPokemon(2, 2729, 202, 5000, 4));

    }
}