package UT7Ejer4BatallaPokemon_V2;

public class Squirtle implements Pokemon, Agua {
    private String nombre;

    public Squirtle() {
        this.nombre = "Squirtle";
    }

    @Override
    public void atacar(Pokemon enemigo) {
        int danoBase = 20;
        System.out.println(nombre + " ataca a " + enemigo.getNombre() + " con daño base de " + danoBase);
        enemigo.recibirAtaque(this, danoBase);
        // Aplica su habilidad de “quemar” al enemigo y muestra el daño extra causado.
        int extraDano = quemar(enemigo);
        if (extraDano > 0) {
            System.out.println(nombre + " quema a " + enemigo.getNombre() + " causando daño extra de " + extraDano);
        }
    }

    @Override
    public void recibirAtaque(Pokemon agresor, int cantidadDano) {
        System.out.println(nombre + " recibe " + cantidadDano + " puntos de daño de " + agresor.getNombre());
    }

    @Override
    public int quemar(Pokemon agresor) {
        // Por ejemplo, si el agresor es de tipo Fuego se causa más daño extra
        if (agresor instanceof Fuego) {
            return 10;
        }
        return 5;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}