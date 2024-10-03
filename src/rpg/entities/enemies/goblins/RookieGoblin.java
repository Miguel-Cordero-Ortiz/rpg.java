package rpg.entities.enemies.goblins;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import javax.swing.JOptionPane;

/**
 * Clase RookieGoblin que extiende de Enemy.
 * Representa un enemigo de tipo RookieGoblin con estadísticas específicas y dos tipos de ataques: estocada y golpe.
 */
public class RookieGoblin extends Enemy {

    /**
     * Constructor que inicializa al RookieGoblin con un nombre predefinido y sus estadísticas.
     */
    public RookieGoblin() {
        super("Rookie Goblin");
        this.stats.put(Stats.MAX_HP, 50); // Vida máxima del Rookie Goblin
        this.stats.put(Stats.HP, 50);     // Vida inicial del Rookie Goblin
        this.stats.put(Stats.ATTACK, 10); // Valor de ataque del Rookie Goblin
        this.stats.put(Stats.DEFENSE, 5); // Valor de defensa del Rookie Goblin
    }

    /**
     * Método que implementa el ataque del RookieGoblin.
     * Elige aleatoriamente entre dos tipos de ataque: estocada y golpe.
     *
     * @param enemy El personaje enemigo al que se atacará.
     */
    @Override
    public void attack(GameCharacter enemy) {
        int attackType = (int) (Math.random() * 2);  // Selecciona aleatoriamente 0 o 1 para el tipo de ataque
        int damage = 0;

        switch (attackType) {
            case 0:
                damage = stab();  // Realiza el ataque de estocada
                break;
            case 1:
                damage = swing();  // Realiza el ataque de golpe
                break;
        }

        // Actualiza los puntos de vida del enemigo después del ataque
        enemy.getStats().put(Stats.HP, Math.max(enemy.getStats().get(Stats.HP) - damage, 0));
        // Muestra el mensaje del ataque y la vida restante del enemigo en una ventana emergente
        JOptionPane.showMessageDialog(null, this.getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
        JOptionPane.showMessageDialog(null, enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    /**
     * Método privado que realiza el ataque de estocada del RookieGoblin.
     * Calcula un daño aleatorio entre 3 y 7.
     *
     * @return El daño infligido.
     */
    private int stab() {
        return (int) (Math.random() * 5 + 3);  // Daño aleatorio entre 3 y 7
    }

    /**
     * Método privado que realiza el ataque de golpe del RookieGoblin.
     * Calcula un daño aleatorio entre 2 y 6.
     *
     * @return El daño infligido.
     */
    private int swing() {
        return (int) (Math.random() * 4 + 2);  // Daño aleatorio entre 2 y 6
    }
}