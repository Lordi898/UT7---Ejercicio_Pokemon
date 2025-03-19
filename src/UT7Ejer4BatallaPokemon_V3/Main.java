package UT7Ejer4BatallaPokemon_V3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creación de instancias con atributos definidos
        Pokemon charmander = new Charmander(100, 30, 20, 25, 15);
        Pokemon squirtle = new Squirtle(110, 25, 25, 20, 20);
        Pokemon bulbasaur = new Bulbasaur(105, 28, 22, 22, 25);

        // Asignación de apodos por parte del usuario
        System.out.print("Ingresa un apodo para Charmander: ");
        charmander.apodar(sc.nextLine());

        System.out.print("Ingresa un apodo para Squirtle: ");
        squirtle.apodar(sc.nextLine());

        System.out.print("Ingresa un apodo para Bulbasaur: ");
        bulbasaur.apodar(sc.nextLine());

        // Mostrar información inicial de cada Pokémon
        System.out.println("\n--- Datos iniciales ---");
        System.out.println(charmander);
        System.out.println(squirtle);
        System.out.println(bulbasaur);
        System.out.println();

        // Lista de combatientes para la simulación
        List<Pokemon> combatientes = new ArrayList<>();
        combatientes.add(charmander);
        combatientes.add(squirtle);
        combatientes.add(bulbasaur);

        Random rand = new Random();
        int round = 1;

        // Simulación del combate: mientras más de un Pokémon tenga vida
        while (countVivos(combatientes) > 1) {
            System.out.println("=== Ronda " + round + " ===");

            // Cada Pokémon vivo ataca a un enemigo seleccionado al azar
            for (Pokemon atacante : combatientes) {
                if (atacante.getVida() <= 0) continue;

                // Seleccionar un enemigo vivo (distinto al atacante)
                List<Pokemon> posibles = new ArrayList<>();
                for (Pokemon p : combatientes) {
                    if (p != atacante && p.getVida() > 0) {
                        posibles.add(p);
                    }
                }
                if (posibles.isEmpty()) break;
                Pokemon objetivo = posibles.get(rand.nextInt(posibles.size()));

                atacante.atacar(objetivo);
                // Verificar si el objetivo fue derrotado
                if (objetivo.getVida() <= 0) {
                    System.out.println((objetivo.getApodo().isEmpty() ? objetivo.getClass().getSimpleName() : objetivo.getApodo())
                            + " ha sido derrotado!");
                }
                System.out.println();

                // Si solo queda un Pokémon vivo, finaliza la ronda
                if (countVivos(combatientes) == 1) break;
            }

            round++;
        }

        // Determinar y mostrar el ganador
        Pokemon ganador = null;
        for (Pokemon p : combatientes) {
            if (p.getVida() > 0) {
                ganador = p;
                break;
            }
        }

        System.out.println("¡El ganador es " + (ganador.getApodo().isEmpty() ? ganador.getClass().getSimpleName() : ganador.getApodo()) + "!");

        sc.close();
    }

    // Método auxiliar para contar cuántos Pokémon están vivos
    public static int countVivos(List<Pokemon> list) {
        int count = 0;
        for (Pokemon p : list) {
            if (p.getVida() > 0) count++;
        }
        return count;
    }
}