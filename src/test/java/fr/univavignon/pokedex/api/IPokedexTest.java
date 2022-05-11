package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class IPokedexTest {
    IPokedex pokedex;
    PokemonMetadata bulbizarre, aquali;
    List<Pokemon> pokemonList;


    @Before
    public void setUp() throws Exception {
        pokedex = new Pokedex();

        // Pokedex pour comparaison.
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100);
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        pokemonList = new ArrayList(Arrays.asList(bulbizarre, aquali));
        pokedex.addPokemon(new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100));
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));

    }

    @Test
    public void testSize() {
        // Retourne la taille du pokepaf.
        Assert.assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        // Retourne l'index du pokedex (size+1) quand on ajoute un pokemon.
        Assert.assertEquals(pokemonList.size() + 1, pokedex.addPokemon(new Pokemon(1, "magomed", 200, 200, 1000, 4000, 4000, 4000, 4, 100)));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Retourne un pokemon (aquali) avec l'index du pokedex (0).
        Assert.assertEquals(aquali.getName(), pokedex.getPokemon(0).getName());
        Assert.assertEquals(aquali.getIndex(), pokedex.getPokemon(0).getIndex());

        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(1000));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-10));

        // Test de l'exception.
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(66));

    }

    @Test
    public void testGetPokemons() {
        // Retourne une liste (unmodificableList).
        Assert.assertEquals(Collections.unmodifiableList(pokemonList).getClass(), pokedex.getPokemons().getClass());
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

        for (Pokemon p : pokedex.getPokemons(PokemonComparators.NAME))

            // Retourne une liste (unmodificableList) trié.
            Assert.assertEquals("Aquali", pokedex.getPokemons(PokemonComparators.NAME).get(0).getName());
        Assert.assertEquals(2729, pokedex.getPokemons(PokemonComparators.NAME).get(0).getCp());
        Assert.assertEquals(4, pokedex.getPokemons(PokemonComparators.NAME).get(0).getCandy());
        Assert.assertEquals(100, pokedex.getPokemons(PokemonComparators.NAME).get(0).getIv(), 0);
        Assert.assertEquals(5000, pokedex.getPokemons(PokemonComparators.NAME).get(0).getDust());
        Assert.assertEquals(202, pokedex.getPokemons(PokemonComparators.NAME).get(0).getHp());


        Assert.assertEquals(613, pokedex.getPokemons(PokemonComparators.CP).get(0).getCp());
        Assert.assertEquals(4, pokedex.getPokemons(PokemonComparators.INDEX).get(0).getCandy());

    }

    @Test
    public void testCreatePokemon() {
        Assert.assertEquals("Aquali", pokedex.createPokemon(133, 2729, 202, 5000, 4).getName());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        Assert.assertEquals("Aquali", pokedex.getPokemonMetadata(133).getName());

        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemonMetadata(2));
    }
}