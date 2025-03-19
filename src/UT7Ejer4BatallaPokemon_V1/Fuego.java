package UT7Ejer4BatallaPokemon_V1;

public interface Fuego {
    /**
     * Método que aplica la resistencia ante un ataque.
     * Se retorna un multiplicador para el daño: 0.5 si se aplica la resistencia, 1.0 en caso contrario.
     */
    double aplicarResistencia(Pokemon agresor);
}