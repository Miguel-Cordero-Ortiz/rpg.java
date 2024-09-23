/**
 * Clase que representa a un enemigo en el juego.
 */
package rpg.entities;

import rpg.enums.Stats;

import javax.swing.*;
import java.util.HashMap;

public class Enemy {
    private String name;  // Nombre del enemigo.
    private HashMap<Stats, Integer> stats;  // Estadísticas del enemigo.

    /**
     * Constructor que inicializa el nombre y las estadísticas del enemigo.
     * @param name Nombre del enemigo.
     */
    public Enemy(String name) {
        this.name = name;
        stats = new HashMap<>();
        stats.put(Stats.MAX_HP, 20);
        stats.put(Stats.HP, 10);
        stats.put(Stats.ATTACK, 8);
        stats.put(Stats.DEFENSE, 3);
    }

    /**
     * Obtiene el nombre del enemigo.
     * @return Nombre del enemigo.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la defensa del enemigo.
     * @return Valor de defensa del enemigo.
     */
    public int getDefense() {
        return stats.get(Stats.DEFENSE);
    }

    /**
     * Realiza un ataque al jugador.
     * @param player El jugador que será atacado.
     */
    public void attack(Player player) {
        int damage = stats.get(Stats.ATTACK) - player.getDefense();
        player.takeDamage(damage);
        JOptionPane.showMessageDialog(null, name + " ataca a " + player.getName() + " y causa " + damage + " de daño.");
    }

    /**
     * Aplica daño al enemigo.
     * @param damage Cantidad de daño a recibir.
     */
    public void takeDamage(int damage) {
        int currentHP = stats.get(Stats.HP);
        stats.put(Stats.HP, Math.max(0, currentHP - damage));
    }

    /**
     * Obtiene los puntos de vida actuales del enemigo.
     * @return Puntos de vida del enemigo.
     */
    public int getHP() {
        return stats.get(Stats.HP);
    }
}
