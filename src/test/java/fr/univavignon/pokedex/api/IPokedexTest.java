package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

public class IPokedexTest {
    IPokedex iPokedex;
    PokemonMetadata bulbizarre, aquali;
    List<Pokemon> pokemonList;


    @Before
    public void setUp() throws Exception {
        iPokedex = Mockito.mock(IPokedex.class);

        // Pokedex pour comparaison.
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100);
        pokemonList = new ArrayList(Arrays.asList(bulbizarre, aquali));

    }

    @Test
    public void testSize() {
        // Retourne la taille du pokepaf.
        Mockito.doReturn(pokemonList.size()).when(iPokedex).size();
        Assert.assertEquals(2, iPokedex.size());
    }

    @Test
    public void testAddPokemon() {
        // Retourne l'index du pokedex (size+1) quand on ajoute un pokemon.
        Mockito.doReturn(pokemonList.size() + 1).when(iPokedex).addPokemon(Mockito.any(Pokemon.class));
        Assert.assertEquals(3, iPokedex.addPokemon(new Pokemon(1, "magomed", 200, 200, 1000, 4000, 4000, 4000, 4, 100)));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Retourne un pokemon (aquali) avec l'index du pokedex (0).
        Mockito.doReturn(aquali).when(iPokedex).getPokemon(0);
        Assert.assertEquals(aquali, iPokedex.getPokemon(0));

        // Test de l'exception.
        Mockito.doThrow(PokedexException.class).when(iPokedex).getPokemon(Mockito.intThat(index -> index < 0 || index > 1));
        Assert.assertThrows(PokedexException.class, () -> iPokedex.getPokemon(66));

    }

    @Test
    public void testGetPokemons() {
        // Retourne une liste (unmodificableList).
        Mockito.doReturn(Collections.unmodifiableList(pokemonList)).when(iPokedex).getPokemons();
        Assert.assertEquals(Collections.unmodifiableList(pokemonList), iPokedex.getPokemons());
    }

    @Test
    public void testGetPokemonsOrder() {
        // Les listes pour comparer.
        List<Pokemon> pokemonListSortedByName = new ArrayList<>(pokemonList);
        pokemonListSortedByName.sort(PokemonComparators.NAME);
        List<Pokemon> pokemonListSortedByIndex = new ArrayList<>(pokemonList);
        pokemonListSortedByIndex.sort(PokemonComparators.INDEX);
        List<Pokemon> pokemonListSortedByCP = new ArrayList<>(pokemonList);
        pokemonListSortedByCP.sort(PokemonComparators.CP);

        // Retourne une liste (unmodificableList) trié.
        Mockito.doReturn(Collections.unmodifiableList(pokemonListSortedByName)).when(iPokedex).getPokemons(PokemonComparators.NAME);
        Mockito.doReturn(Collections.unmodifiableList(pokemonListSortedByIndex)).when(iPokedex).getPokemons(PokemonComparators.INDEX);
        Mockito.doReturn(Collections.unmodifiableList(pokemonListSortedByCP)).when(iPokedex).getPokemons(PokemonComparators.CP);

        Assert.assertEquals("Aquali", iPokedex.getPokemons(PokemonComparators.NAME).get(0).getName());
        Assert.assertEquals(613, iPokedex.getPokemons(PokemonComparators.CP).get(0).getCp());
        Assert.assertEquals(0, iPokedex.getPokemons(PokemonComparators.INDEX).get(0).getIndex());
    }
}