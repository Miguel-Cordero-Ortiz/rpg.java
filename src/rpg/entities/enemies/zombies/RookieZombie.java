package rpg.entities.enemies.zombies;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import javax.swing.JOptionPane;
/**
 * Clase RookieZombie que extiende de Enemy.
 * Representa a un enemigo RookieZombie con estadísticas específicas y dos tipos de ataque: mordida y rasguño.
 */
public class RookieZombie extends Enemy {
    /**
     * Constructor que inicializa al RookieZombie con un nombre predefinido y sus estadísticas.
     */
    public RookieZombie() {
        super("Rookie Zombie");
        this.stats.put(Stats.MAX_HP, 40); // Vida máxima del Rookie Zombie
        this.stats.put(Stats.HP, 40);     // Vida inicial del Rookie Zombie
        this.stats.put(Stats.ATTACK, 15); // Valor de ataque del Rookie Zombie
        this.stats.put(Stats.DEFENSE, 8); // Valor de defensa del Rookie Zombie
    }
    /**
     * Método que implementa el ataque del RookieZombie.
     * Elige aleatoriamente entre dos ataques: mordida o rasguño.
     *
     * @param enemy El personaje enemigo al que se atacará.
     */
    @Override
    public void attack(GameCharacter enemy) {
        int attackType = (int) (Math.random() * 2);  // Selecciona aleatoriamente 0 o 1 para el tipo de ataque
        int damage = 0;

        switch (attackType) {
            case 0:
                damage = bite(enemy); // Realiza una mordida
                break;
            case 1:
                damage = scratch(enemy); // Realiza un rasguño
                break;
        }
// Actualiza los puntos de vida del enemigo después del ataque
        enemy.getStats().put(Stats.HP, Math.max(enemy.getStats().get(Stats.HP) - damage, 0));
        // Muestra el mensaje del ataque y la vida restante en una ventana emergente
        JOptionPane.showMessageDialog(null, this.getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
        JOptionPane.showMessageDialog(null, enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }
    /**
     * Método privado que realiza el ataque de mordida del RookieZombie.
     * Calcula el daño aleatorio entre 2 y 7 y lo compara con la defensa del enemigo.
     *
     * @param enemy El enemigo al que se atacará.
     * @return El daño infligido.
     */
    private int bite(GameCharacter enemy) {
        int damage = (int) (Math.random() * 6) + 2;  // Daño entre 2 y 7
        return Math.max(damage, this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE));
    }
    /**
     * Método privado que realiza el ataque de rasguño del RookieZombie.
     * Calcula el daño aleatorio entre 4 y 9 y lo compara con la defensa del enemigo.
     *
     * @param enemy El enemigo al que se atacará.
     * @return El daño infligido.
     */
    private int scratch(GameCharacter enemy) {
        int damage = (int) (Math.random() * 6) + 4;  // Daño aleatorio entre 4 y 9
        return Math.max(damage, this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE));
    }
}