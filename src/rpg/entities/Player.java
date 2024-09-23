package rpg.entities;
import rpg.enums.Stats;

import javax.swing.*;
import java.util.HashMap;
public class Player {
    private String name;
    private HashMap<Stats, Integer> stats;
    public Player(String name) {
        this.name = name;
        stats = new HashMap<>();
        stats.put(Stats.MAX_HP, 30);
        stats.put(Stats.HP, 20);
        stats.put(Stats.ATTACK, 10);
        stats.put(Stats.DEFENSE, 5);
        // Agrega las demás estadísticas
    }
    public String getName() {
        return name;
    }
    public int getDefense() {
        return stats.get(Stats.DEFENSE);
    }
    public int getHP() {
        return stats.get(Stats.HP);
    }
    public void attack(Enemy enemy) {
        int damage = stats.get(Stats.ATTACK) - enemy.getDefense();
        enemy.takeDamage(damage);
        JOptionPane.showMessageDialog(null, name + " ataca a " + enemy.getName() + " y causa " + damage + " de daño.");
    }
    public void takeDamage(int damage) {
        int currentHP = stats.get(Stats.HP);
        stats.put(Stats.HP, Math.max(0, currentHP - damage));
    }
}
