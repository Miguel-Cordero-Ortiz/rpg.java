/**
 * Clase que representa al jugador en el juego.
 */
package rpg.entities;

import rpg.enums.Stats;

import javax.swing.*;
import java.util.HashMap;

public class Player {
    private String name;  // Nombre del jugador.
    private HashMap<Stats, Integer> stats;  // Estadísticas del jugador.

    /**
     * Constructor que inicializa el nombre y las estadísticas del jugador.
     * @param name Nombre del jugador.
     */
    public Player(String name) {
        this.name = name;
        stats = new HashMap<>();
        stats.put(Stats.MAX_HP, 30);
        stats.put(Stats.HP, 20);
        stats.put(Stats.ATTACK, 10);
        stats.put(Stats.DEFENSE, 5);
    }

    /**
     * Obtiene el nombre del jugador.
     * @return Nombre del jugador.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la defensa del jugador.
     * @return Valor de defensa del jugador.
     */
    public int getDefense() {
        return stats.get(Stats.DEFENSE);
    }

    /**
     * Obtiene los puntos de vida actuales del jugador.
     * @return Puntos de vida del jugador.
     */
    public int getHP() {
        return stats.get(Stats.HP);
    }

    /**
     * Realiza un ataque al enemigo.
     * @param enemy El enemigo que será atacado.
     */
    public void attack(Enemy enemy) {
        int damage = stats.get(Stats.ATTACK) - enemy.getDefense();
        enemy.takeDamage(damage);
        JOptionPane.showMessageDialog(null, name + " ataca a " + enemy.getName() + " y causa " + damage + " de daño.");
    }

    /**
     * Aplica daño al jugador.
     * @param damage Cantidad de daño a recibir.
     */
    public void takeDamage(int damage) {
        int currentHP = stats.get(Stats.HP);
        stats.put(Stats.HP, Math.max(0, currentHP - damage));
    }
}
