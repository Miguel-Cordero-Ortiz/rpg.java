package rpg.entities;
import rpg.enums.Stats;

import javax.swing.*;
import java.util.HashMap;
public class Enemy {
    private String name;
    private HashMap<Stats, Integer> stats;
    public Enemy(String name) {
        this.name = name;
        stats = new HashMap<>();
        stats.put(Stats.MAX_HP, 20);
        stats.put(Stats.HP, 10);
        stats.put(Stats.ATTACK, 8);
        stats.put(Stats.DEFENSE, 3);
        // Agrega las demás estadísticas
    }
    public String getName() {
        return name;
    }
    public int getDefense() {
        return stats.get(Stats.DEFENSE);
    }
    public void attack(Player player) {
        int damage = stats.get(Stats.ATTACK) - player.getDefense();
        player.takeDamage(damage);
        JOptionPane.showMessageDialog(null, name + " ataca a " + player.getName() + " y causa " + damage + " de daño.");
    }
    public void takeDamage(int damage) {
        int currentHP = stats.get(Stats.HP);
        stats.put(Stats.HP, Math.max(0, currentHP - damage));
    }
    public int getHP() {
        return stats.get(Stats.HP);
    }
}