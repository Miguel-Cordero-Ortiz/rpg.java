package rpg.entities.enemies.slimes;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import javax.swing.JOptionPane;

/**
 * Clase BasicSlime que extiende de Enemy.
 * Representa un enemigo de tipo BasicSlime con estadísticas específicas y dos tipos de ataques: secreción y golpe.
 */
public class BasicSlime extends Enemy {

    /**
     * Constructor que inicializa al BasicSlime con un nombre predefinido y sus estadísticas.
     */
    public BasicSlime() {
        super("Basic Slime");
        this.stats.put(Stats.MAX_HP, 40); // Vida máxima del Basic Slime
        this.stats.put(Stats.HP, 40);     // Vida inicial del Basic Slime
        this.stats.put(Stats.ATTACK, 8);  // Valor de ataque del Basic Slime
        this.stats.put(Stats.DEFENSE, 4); // Valor de defensa del Basic Slime
    }

    /**
     * Método que implementa el ataque del BasicSlime.
     * Elige aleatoriamente entre dos tipos de ataque: secreción o golpe.
     *
     * @param enemy El personaje enemigo al que se atacará.
     */
    @Override
    public void attack(GameCharacter enemy) {
        int attackType = (int) (Math.random() * 2);  // Selecciona aleatoriamente 0 o 1 para el tipo de ataque
        int damage = 0;

        switch (attackType) {
            case 0:
                damage = ooze();  // Realiza el ataque de secreción
                break;
            case 1:
                damage = slam();  // Realiza el ataque de golpe
                break;
        }

        // Actualiza los puntos de vida del enemigo después del ataque
        enemy.getStats().put(Stats.HP, Math.max(enemy.getStats().get(Stats.HP) - damage, 0));
        // Muestra el mensaje del ataque y la vida restante del enemigo en una ventana emergente
        JOptionPane.showMessageDialog(null, this.getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
        JOptionPane.showMessageDialog(null, enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    /**
     * Método privado que realiza el ataque de secreción del BasicSlime.
     * Calcula un daño aleatorio entre 2 y 5.
     *
     * @return El daño infligido.
     */
    private int ooze() {
        return (int) (Math.random() * 4 + 2);  // Daño aleatorio entre 2 y 5
    }

    /**
     * Método privado que realiza el ataque de golpe del BasicSlime.
     * Calcula un daño aleatorio entre 2 y 4.
     *
     * @return El daño infligido.
     */
    private int slam() {
        return (int) (Math.random() * 3 + 2);  // Daño aleatorio entre 2 y 4
    }
}