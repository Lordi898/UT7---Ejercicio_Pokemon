package UT7Ejer4BatallaPokemon_V2;

public class Bulbasaur implements Pokemon, Planta {
    private String nombre;

    public Bulbasaur() {
        this.nombre = "Bulbasaur";
    }

    @Override
    public void atacar(Pokemon enemigo) {
        int danoBase = 20;
        System.out.println(nombre + " ataca a " + enemigo.getNombre() + " con daño base de " + danoBase);
        enemigo.recibirAtaque(this, danoBase);
    }

    @Override
    public void recibirAtaque(Pokemon agresor, int cantidadDano) {
        System.out.println(nombre + " recibe " + cantidadDano + " puntos de daño de " + agresor.getNombre());
        // Tras recibir un ataque, recupera algo de vida usando su habilidad
        int vidaRecuperada = recuperarVida();
        System.out.println(nombre + " se recupera " + vidaRecuperada + " puntos de vida.");
    }

    @Override
    public int recuperarVida() {
        // Recupera una cantidad fija de vida, por ejemplo 10 puntos.
        return 10;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}