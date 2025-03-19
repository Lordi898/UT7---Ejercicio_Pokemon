package UT7Ejer4BatallaPokemon_V2;

public interface Pokemon {
    void atacar(Pokemon enemigo);
    void recibirAtaque(Pokemon agresor, int cantidadDano);
    String getNombre();
}