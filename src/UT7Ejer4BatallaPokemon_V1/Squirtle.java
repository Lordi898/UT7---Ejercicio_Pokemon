package UT7Ejer4BatallaPokemon_V1;

public class Squirtle implements Pokemon, Agua {
    private String nombre;
    private int vida;
    private int ataque;

    public Squirtle() {
        this.nombre = "Squirtle";
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
        // Si el agresor no es de tipo Agua, se invoca la resistencia
        if (!(agresor instanceof Agua)) {
            factor = aplicarResistencia(agresor);
        }
        int damageRecibido = (int)(baseDamage * factor);
        this.vida -= damageRecibido;
        System.out.println(this.nombre + " recibe " + damageRecibido + " puntos de daño. Vida restante: " + this.vida);
    }

    /**
     * Un Pokémon Agua (Squirtle) recibe la mitad del daño si es atacado por un Pokémon Fuego.
     */
    @Override
    public double aplicarResistencia(Pokemon agresor) {
        if (agresor instanceof Fuego) {
            System.out.println(this.nombre + " aplica resistencia (ataque de Fuego): daño reducido a la mitad.");
            return 0.5;
        }
        return 1.0;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}