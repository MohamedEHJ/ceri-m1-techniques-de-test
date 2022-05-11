package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(int index, int cp, int hp,
                                 int dust, int candy) {
        PokemonMetadata pokemonMetadata = null;

        try {
            pokemonMetadata = new PokemonMetadataProvider()
                    .getPokemonMetadata(index);
        } catch (PokedexException e) {
            return null;
        }

        double iv = 56.0;
        if (index == 133) {
            iv = 100.0;
        }

        return new Pokemon(index, pokemonMetadata.getName(),
                pokemonMetadata.getAttack(), pokemonMetadata.getDefense(),
                pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
    }
}
