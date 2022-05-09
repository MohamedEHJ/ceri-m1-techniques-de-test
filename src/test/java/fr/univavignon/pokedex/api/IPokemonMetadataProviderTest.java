package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    PokemonMetadata bulbizarre;
    PokemonMetadata aquali;

    @Before
    public void setUp() throws Exception {
        iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 168, 186, 260);

    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException{
        // Test du provider.
        Mockito.doReturn(bulbizarre).when(iPokemonMetadataProvider).getPokemonMetadata(0);
        Mockito.doReturn(aquali).when(iPokemonMetadataProvider).getPokemonMetadata(133);

        Assert.assertEquals(bulbizarre, iPokemonMetadataProvider.getPokemonMetadata(0));
        Assert.assertEquals(aquali, iPokemonMetadataProvider.getPokemonMetadata(133));


        // Test des exceptions.
        Mockito.doThrow(new PokedexException("Index non valide")).when(iPokemonMetadataProvider).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));

        Assert.assertThrows(PokedexException.class, () -> iPokemonMetadataProvider.getPokemonMetadata(-6));
        Assert.assertThrows(PokedexException.class, () -> iPokemonMetadataProvider.getPokemonMetadata(154));
    }
}