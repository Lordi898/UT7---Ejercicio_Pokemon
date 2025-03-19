package UT7Ejer4BatallaPokemon_V3;

public class Bulbasaur extends Pokemon implements Planta {

    public Bulbasaur(int vida, int ataque, int defensa, int velocidad, int especial) {
        super(vida, ataque, defensa, velocidad, especial);
    }

    @Override
    public void atacar(Pokemon enemigo) {
        double base = this.ataque - enemigo.getDefensa();
        if (base < 0) base = 0;
        double speedFactor = (double)this.velocidad / enemigo.getVelocidad();
        double damage = base * speedFactor;

        // Bulbasaur tiene ventaja si ataca a un Pokémon de tipo Agua.
        if (enemigo instanceof Agua) {
            System.out.println((apodo.isEmpty() ? "Bulbasaur" : apodo) + " tiene ventaja sobre " +
                    (enemigo.getApodo().isEmpty() ? enemigo.getClass().getSimpleName() : enemigo.getApodo()));
            damage *= 2;
        }

        System.out.println((apodo.isEmpty() ? "Bulbasaur" : apodo) + " ataca a " +
                (enemigo.getApodo().isEmpty() ? enemigo.getClass().getSimpleName() : enemigo.getApodo())
                + " causando " + (int)damage + " de daño.");
        enemigo.recibirAtaque(this, (int)damage);
    }

    @Override
    public void recibirAtaque(Pokemon agresor, int cantidadDano) {
        double factor = aplicarResistencia(agresor);
        int damageFinal = (int)(cantidadDano * factor);
        this.vida -= damageFinal;
        if(this.vida < 0) this.vida = 0;
        System.out.println((apodo.isEmpty() ? "Bulbasaur" : apodo) + " recibe " + damageFinal +
                " de daño, vida restante: " + this.vida);
    }

    // Bulbasaur resiste ataques de tipo Agua
    @Override
    public double aplicarResistencia(Pokemon atacante) {
        if (atacante instanceof Agua) {
            System.out.println((apodo.isEmpty() ? "Bulbasaur" : apodo) + " resiste el ataque de tipo Agua, daño reducido a la mitad.");
            return 0.5;
        }
        return 1.0;
    }
}