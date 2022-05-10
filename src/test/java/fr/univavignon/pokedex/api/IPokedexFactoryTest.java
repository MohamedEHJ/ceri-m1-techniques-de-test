package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.implementation.PokedexFactory;
import fr.univavignon.pokedex.api.implementation.Pokedex;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    PokemonMetadata bulbizarre;
    PokemonMetadata aquali;


    /**
     * Constructeur du test
     */
    public IPokedexFactoryTest() {
        pokedexFactory = new PokedexFactory();
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    }

    @Test
    public void testCreatePokedex() {
        IPokemonFactory iPokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        Assert.assertEquals(Pokedex.class, pokedexFactory.createPokedex(pokemonMetadataProvider, iPokemonFactory).getClass());
    }
}