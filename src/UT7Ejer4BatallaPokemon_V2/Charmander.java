package UT7Ejer4BatallaPokemon_V2;

public class Charmander implements Pokemon, Fuego {
    private String nombre;

    public Charmander() {
        this.nombre = "Charmander";
    }

    @Override
    public void atacar(Pokemon enemigo) {
        int danoBase = 20;
        System.out.println(nombre + " ataca a " + enemigo.getNombre() + " con daño base de " + danoBase);
        enemigo.recibirAtaque(this, danoBase);
    }

    @Override
    public void recibirAtaque(Pokemon agresor, int cantidadDano) {
        double factor = 1.0;
        // Si el agresor es de tipo Fuego, se aplica la resistencia
        if (agresor instanceof Fuego) {
            factor = resistenciaAlFuego(agresor);
            System.out.println(nombre + " utiliza resistencia al fuego, factor: " + factor);
        }
        int danoFinal = (int)(cantidadDano * factor);
        System.out.println(nombre + " recibe " + danoFinal + " puntos de daño de " + agresor.getNombre());
    }

    @Override
    public double resistenciaAlFuego(Pokemon agresor) {
        // Por ejemplo, si el agresor es de tipo Fuego, reduce el daño a la mitad.
        if (agresor instanceof Fuego) {
            return 0.5;
        }
        return 1.0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}