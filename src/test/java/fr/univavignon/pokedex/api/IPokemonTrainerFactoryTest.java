package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory iPokemonTrainerFactory;
    PokemonTrainer mohamed, incelTrainer;
    IPokedex iPokedex;
    IPokedexFactory iPokedexFactory;

    @Before
    public void setUp() throws Exception {
        iPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        iPokedex = Mockito.mock(IPokedex.class);
        iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        mohamed = new PokemonTrainer("Mohamed", Team.VALOR, iPokedex);
        incelTrainer = new PokemonTrainer("incel", Team.INSTINCT, iPokedex);

    }

    @Test
    public void createTrainer() {
        Mockito.doReturn(mohamed).when(iPokemonTrainerFactory).createTrainer("Mohamed", Team.VALOR, iPokedexFactory);
        Mockito.doReturn(incelTrainer).when(iPokemonTrainerFactory).createTrainer("incel", Team.INSTINCT, iPokedexFactory);

        Assert.assertEquals(mohamed, iPokemonTrainerFactory.createTrainer("Mohamed", Team.VALOR, iPokedexFactory));
        Assert.assertEquals(incelTrainer, iPokemonTrainerFactory.createTrainer("incel", Team.INSTINCT, iPokedexFactory));

    }
}