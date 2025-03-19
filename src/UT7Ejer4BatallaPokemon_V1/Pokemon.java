package UT7Ejer4BatallaPokemon_V1;

public interface Pokemon {
    // Método para atacar a otro Pokémon
    void atacar(Pokemon enemigo);
    // Método para recibir un ataque de otro Pokémon
    void recibirAtaque(Pokemon agresor);

    // Método auxiliar para obtener el nombre del Pokémon (para mostrar mensajes)
    String getNombre();
}