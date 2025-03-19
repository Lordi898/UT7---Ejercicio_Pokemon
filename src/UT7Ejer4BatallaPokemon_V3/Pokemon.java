package UT7Ejer4BatallaPokemon_V3;

public abstract class Pokemon {
    protected String apodo;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected int especial;
    protected int nivel;
    protected int puntosExperiencia;

    public Pokemon(int vida, int ataque, int defensa, int velocidad, int especial) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.especial = especial;
        this.nivel = 1;
        this.puntosExperiencia = 0;
        this.apodo = "";
    }

    // Permite asignar un apodo al Pokémon
    public void apodar(String apodo) {
        this.apodo = apodo;
    }

    public String getApodo() {
        return apodo;
    }

    public int getVida() {
        return vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    // Métodos abstractos a implementar en las subclases
    public abstract void atacar(Pokemon enemigo);
    public abstract void recibirAtaque(Pokemon agresor, int cantidadDano);

    @Override
    public String toString() {
        return "Pokemon: " + (apodo.isEmpty() ? getClass().getSimpleName() : apodo)
                + " | Vida: " + vida
                + " | Ataque: " + ataque
                + " | Defensa: " + defensa
                + " | Velocidad: " + velocidad
                + " | Especial: " + especial
                + " | Nivel: " + nivel
                + " | XP: " + puntosExperiencia;
    }
}