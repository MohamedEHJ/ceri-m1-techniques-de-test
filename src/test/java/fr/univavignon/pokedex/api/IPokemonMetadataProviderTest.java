package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;
    PokemonMetadata bulbizarre;
    PokemonMetadata aquali;

    @Before
    public void setUp() throws Exception {
        pokemonMetadataProvider = new PokemonMetadataProvider();
        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException{
        // Test du provider.
        Assert.assertEquals(bulbizarre.getName(), pokemonMetadataProvider.getPokemonMetadata(0).getName());
        Assert.assertEquals(aquali.getName(), pokemonMetadataProvider.getPokemonMetadata(133).getName());

        Assert.assertEquals(bulbizarre.getAttack(), pokemonMetadataProvider.getPokemonMetadata(0).getAttack());
        Assert.assertEquals(aquali.getAttack(), pokemonMetadataProvider.getPokemonMetadata(133).getAttack());

        Assert.assertEquals(bulbizarre.getDefense(), pokemonMetadataProvider.getPokemonMetadata(0).getDefense());
        Assert.assertEquals(aquali.getDefense(), pokemonMetadataProvider.getPokemonMetadata(133).getDefense());


        // Test des exceptions.
        Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-6));
        Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(154));
    }
}