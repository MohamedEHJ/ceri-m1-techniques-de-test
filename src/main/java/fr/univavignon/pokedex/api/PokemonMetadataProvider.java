package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    /**
     * pokemonMetaDataList.
     */
    private List<PokemonMetadata> pokemonMetadataList;

    public PokemonMetadataProvider() {
        pokemonMetadataList = new ArrayList<>();
        pokemonMetadataList.add(new PokemonMetadata(0, "Bulbizarre",
                126, 126, 90));
        pokemonMetadataList.add(new PokemonMetadata(133, "Aquali",
                186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        for (PokemonMetadata pokemonMetadata : pokemonMetadataList) {
            if (pokemonMetadata.getIndex() == index) {
                return pokemonMetadata;
            }
        }

        throw new PokedexException("getPokemonMetadata: index not in list");
    }
}
