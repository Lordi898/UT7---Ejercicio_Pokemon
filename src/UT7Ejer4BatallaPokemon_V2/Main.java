package UT7Ejer4BatallaPokemon_V2;

public class Main {
    public static void main(String[] args) {
        Pokemon charmander = new Charmander();
        Pokemon squirtle = new Squirtle();
        Pokemon bulbasaur = new Bulbasaur();

        System.out.println("=== Combate: Ronda 1 ===");
        // Charmander ataca a Bulbasaur
        charmander.atacar(bulbasaur);

        System.out.println("\n=== Combate: Ronda 2 ===");
        // Bulbasaur ataca a Squirtle
        bulbasaur.atacar(squirtle);

        System.out.println("\n=== Combate: Ronda 3 ===");
        // Squirtle ataca a Charmander
        squirtle.atacar(charmander);
    }
}