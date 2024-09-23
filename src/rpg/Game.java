package rpg;
import rpg.entities.Enemy;
import rpg.entities.Player;

import javax.swing.*;
import java.util.Scanner;
public class Game {
    private Player player;
    private Enemy enemy;
    public Game() {
        player = new Player("Quijote");
        enemy = new Enemy("Molino de viento");
    }
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (player.getHP() > 0 && enemy.getHP() > 0) {
            player.attack(enemy);
            if (enemy.getHP() > 0) {
                enemy.attack(player);
            }
            JOptionPane.showMessageDialog(null, "HP del jugador: "+ player.getHP() + "\nHP del enemigo: "+ enemy.getHP());
        }
        if (player.getHP() <= 0) {
            JOptionPane.showMessageDialog(null,"Has sido derrotado.");
        } else {
            JOptionPane.showMessageDialog(null,"Has derrotado al enemigo");
        }
        scanner.close();
    }
}
