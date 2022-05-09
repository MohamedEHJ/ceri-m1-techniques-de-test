package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    IPokemonFactory iPokemonFactory;

    Pokemon bulbizarre, aquali;

    @Before
    public void setUp() throws Exception {
        iPokemonFactory = Mockito.mock(IPokemonFactory.class);
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void createPokemon() {
        // Création des pokemons.
        Mockito.when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        Mockito.when(iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);
        Assert.assertEquals(bulbizarre, iPokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        Assert.assertEquals(aquali, iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
    }
}