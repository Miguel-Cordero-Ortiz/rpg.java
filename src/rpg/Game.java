/**
 * Clase que representa el ciclo del juego, gestionando las interacciones entre el jugador y el enemigo.
 */
package rpg;

import rpg.entities.Enemy;
import rpg.entities.Player;

import javax.swing.*;
import java.util.Scanner;

public class Game {
    private Player player;  // El jugador del juego.
    private Enemy enemy;    // El enemigo del juego.

    /**
     * Constructor que inicializa al jugador y al enemigo.
     */
    public Game() {
        player = new Player("Quijote");
        enemy = new Enemy("Molino de viento");
    }

    /**
     * Metodo que inicia el ciclo del juego, alternando turnos entre el jugador y el enemigo.
     */
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (player.getHP() > 0 && enemy.getHP() > 0) {
            player.attack(enemy);
            if (enemy.getHP() > 0) {
                enemy.attack(player);
            }
            JOptionPane.showMessageDialog(null, "HP del jugador: " + player.getHP() + "\nHP del enemigo: " + enemy.getHP());
        }

        if (player.getHP() <= 0) {
            JOptionPane.showMessageDialog(null, "Has sido derrotado.");
        } else {
            JOptionPane.showMessageDialog(null, "Has derrotado al enemigo");
        }
        scanner.close();
    }
}
