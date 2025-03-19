package UT7Ejer4BatallaPokemon_V1;

public class Bulbasaur implements Pokemon, Planta {
    private String nombre;
    private int vida;
    private int ataque;

    public Bulbasaur() {
        this.nombre = "Bulbasaur";
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
        // Si el agresor no es de tipo Planta, se invoca la resistencia
        if (!(agresor instanceof Planta)) {
            factor = aplicarResistencia(agresor);
        }
        int damageRecibido = (int)(baseDamage * factor);
        this.vida -= damageRecibido;
        System.out.println(this.nombre + " recibe " + damageRecibido + " puntos de daño. Vida restante: " + this.vida);
    }

    /**
     * Un Pokémon Planta (Bulbasaur) recibe la mitad del daño si es atacado por un Pokémon Agua.
     */
    @Override
    public double aplicarResistencia(Pokemon agresor) {
        if (agresor instanceof Agua) {
            System.out.println(this.nombre + " aplica resistencia (ataque de Agua): daño reducido a la mitad.");
            return 0.5;
        }
        return 1.0;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}