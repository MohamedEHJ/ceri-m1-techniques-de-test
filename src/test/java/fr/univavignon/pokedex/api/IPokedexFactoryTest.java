package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    IPokedexFactory iPokedexFactory;
    PokemonMetadata bulbizarre;
    PokemonMetadata aquali;

    /**
     * Constructeur du test
     */
    public IPokedexFactoryTest() {
        iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void testCreatePokedex() {
        IPokemonFactory iPokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        // Mock le résultat de createPokedex avec doReturn.
        Mockito.doReturn(Mockito.mock(IPokedex.class)).when(iPokedexFactory).createPokedex(Mockito.any(pokemonMetadataProvider.getClass()), Mockito.any(iPokemonFactory.getClass()));

        Assert.assertEquals(Mockito.mock(IPokedex.class).getClass(), iPokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class)).getClass());
    }
}