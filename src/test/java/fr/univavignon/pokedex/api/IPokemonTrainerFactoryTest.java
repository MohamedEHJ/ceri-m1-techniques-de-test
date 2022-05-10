package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.implementation.Pokedex;
import fr.univavignon.pokedex.api.implementation.PokedexFactory;
import fr.univavignon.pokedex.api.implementation.PokemonTrainerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory pokemonTrainerFactory;
    PokemonTrainer mohamed, incelTrainer;
    IPokedex pokedex;
    IPokedexFactory pokedexFactory;

    @Before
    public void setUp() throws Exception {
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedex = new Pokedex();
        pokedexFactory = new PokedexFactory();
        mohamed = new PokemonTrainer("Mohamed", Team.VALOR, pokedex);
        incelTrainer = new PokemonTrainer("incel", Team.INSTINCT, pokedex);

    }

    @Test
    public void createTrainer() {
        Assert.assertEquals(mohamed.getName(), pokemonTrainerFactory.createTrainer("Mohamed", Team.VALOR, pokedexFactory).getName());
        Assert.assertEquals(mohamed.getTeam(), pokemonTrainerFactory.createTrainer("Mohamed", Team.VALOR, pokedexFactory).getTeam());
        Assert.assertEquals(mohamed.getPokedex().size(), pokemonTrainerFactory.createTrainer("Mohamed", Team.VALOR, pokedexFactory).getPokedex().size());

        Assert.assertEquals(incelTrainer.getName(), pokemonTrainerFactory.createTrainer("incel", Team.INSTINCT, pokedexFactory).getName());
        Assert.assertEquals(incelTrainer.getTeam(), pokemonTrainerFactory.createTrainer("incel", Team.INSTINCT, pokedexFactory).getTeam());

    }
}