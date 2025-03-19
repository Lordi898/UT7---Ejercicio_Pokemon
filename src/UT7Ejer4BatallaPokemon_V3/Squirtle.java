package UT7Ejer4BatallaPokemon_V3;

public class Squirtle extends Pokemon implements Agua {

    public Squirtle(int vida, int ataque, int defensa, int velocidad, int especial) {
        super(vida, ataque, defensa, velocidad, especial);
    }

    @Override
    public void atacar(Pokemon enemigo) {
        double base = this.ataque - enemigo.getDefensa();
        if (base < 0) base = 0;
        double speedFactor = (double)this.velocidad / enemigo.getVelocidad();
        double damage = base * speedFactor;

        // Squirtle tiene ventaja si ataca a un Pokémon de tipo Fuego.
        if (enemigo instanceof Fuego) {
            System.out.println((apodo.isEmpty() ? "Squirtle" : apodo) + " tiene ventaja sobre " +
                    (enemigo.getApodo().isEmpty() ? enemigo.getClass().getSimpleName() : enemigo.getApodo()));
            damage *= 2;
        }

        System.out.println((apodo.isEmpty() ? "Squirtle" : apodo) + " ataca a " +
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
        System.out.println((apodo.isEmpty() ? "Squirtle" : apodo) + " recibe " + damageFinal +
                " de daño, vida restante: " + this.vida);
    }

    // Squirtle resiste ataques de tipo Fuego
    @Override
    public double aplicarResistencia(Pokemon atacante) {
        if (atacante instanceof Fuego) {
            System.out.println((apodo.isEmpty() ? "Squirtle" : apodo) + " resiste el ataque de tipo Fuego, daño reducido a la mitad.");
            return 0.5;
        }
        return 1.0;
    }
}