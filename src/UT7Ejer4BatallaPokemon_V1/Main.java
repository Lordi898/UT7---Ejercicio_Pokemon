package UT7Ejer4BatallaPokemon_V1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        // Se crean las instancias de los tres Pokémon
        Pokemon charmander = new Charmander();
        Pokemon squirtle = new Squirtle();
        Pokemon bulbasaur = new Bulbasaur();

        // Simulación de combate:
        System.out.println("=== Ronda 1 ===");
        // Charmander ataca a Bulbasaur (Bulbasaur no tiene resistencia ante ataques Fuego)
        charmander.atacar(bulbasaur);

        System.out.println("\n=== Ronda 2 ===");
        // Bulbasaur ataca a Squirtle (Squirtle es de Agua y recibe la mitad si es atacado por Fuego,
        // pero en este caso el ataque es de Planta, así que no se aplica resistencia)
        bulbasaur.atacar(squirtle);

        System.out.println("\n=== Ronda 3 ===");
        // Squirtle ataca a Charmander (Charmander es de Fuego y recibe la mitad del daño si es atacado por Planta;
        // aquí el ataque viene de Agua, por lo que no se aplica resistencia)
        squirtle.atacar(charmander);

        // Puedes ampliar la simulación con más rondas o lógica para determinar el ganador.

    }

}
