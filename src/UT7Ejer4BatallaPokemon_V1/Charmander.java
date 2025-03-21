package UT7Ejer4BatallaPokemon_V1;

public class Charmander implements Pokemon, Fuego {
    private String nombre;
    private int vida;
    private int ataque;

    public Charmander() {
        this.nombre = "Charmander";
        this.vida = 100;
        this.ataque = 20;
    }

    @Override
    public void atacar(Pokemon enemigo) {
        System.out.println(this.nombre + " ataca a " + enemigo.getNombre());
        enemigo.recibirAtaque(this);
    }

    @Override
    public void recibirAtaque(Pokemon agresor) {
        int baseDamage = this.ataque;
        double factor = 1.0;
        // Si el agresor no es de tipo Fuego, se invoca la resistencia
        if (!(agresor instanceof Fuego)) {
            factor = aplicarResistencia(agresor);
        }
        int damageRecibido = (int)(baseDamage * factor);
        this.vida -= damageRecibido;
        System.out.println(this.nombre + " recibe " + damageRecibido + " puntos de daño. Vida restante: " + this.vida);
    }

    /**
     * Un Pokémon Fuego (Charmander) recibe la mitad del daño si es atacado por un Pokémon Planta.
     */
    @Override
    public double aplicarResistencia(Pokemon agresor) {
        if (agresor instanceof Planta) {
            System.out.println(this.nombre + " aplica resistencia (ataque de Planta): daño reducido a la mitad.");
            return 0.5;
        }
        return 1.0;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}