package rpg.entities.enemies.skeletons;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import javax.swing.JOptionPane;

/**
 * Clase WeakSkeleton que extiende de Enemy.
 * Representa un enemigo de tipo WeakSkeleton con estadísticas específicas y dos tipos de ataques: lanzar hueso y corte.
 */
public class WeakSkeleton extends Enemy {

    /**
     * Constructor que inicializa al WeakSkeleton con un nombre predefinido y sus estadísticas.
     */
    public WeakSkeleton() {
        super("Weak Skeleton");
        this.stats.put(Stats.MAX_HP, 40); // Vida máxima del Weak Skeleton
        this.stats.put(Stats.HP, 40);     // Vida inicial del Weak Skeleton
        this.stats.put(Stats.ATTACK, 8);  // Valor de ataque del Weak Skeleton
        this.stats.put(Stats.DEFENSE, 4); // Valor de defensa del Weak Skeleton
    }

    /**
     * Método que implementa el ataque del WeakSkeleton.
     * Elige aleatoriamente entre dos tipos de ataque: lanzar hueso o corte.
     *
     * @param enemy El personaje enemigo al que se atacará.
     */
    @Override
    public void attack(GameCharacter enemy) {
        int attackType = (int) (Math.random() * 2);  // Selecciona aleatoriamente 0 o 1 para el tipo de ataque
        int damage = 0;

        switch (attackType) {
            case 0:
                damage = throwBone();  // Realiza el ataque de lanzar hueso
                break;
            case 1:
                damage = swordSlash();  // Realiza el ataque de corte
                break;
        }

        // Actualiza los puntos de vida del enemigo después del ataque
        enemy.getStats().put(Stats.HP, Math.max(enemy.getStats().get(Stats.HP) - damage, 0));
        // Muestra el mensaje del ataque y la vida restante del enemigo en una ventana emergente
        JOptionPane.showMessageDialog(null, this.getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
        JOptionPane.showMessageDialog(null, enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    /**
     * Método privado que realiza el ataque de lanzar hueso del WeakSkeleton.
     * Calcula un daño aleatorio entre 2 y 5.
     *
     * @return El daño infligido.
     */
    private int throwBone() {
        return (int) (Math.random() * 4 + 2);  // Daño aleatorio entre 2 y 5
    }

    /**
     * Método privado que realiza el ataque de corte del WeakSkeleton.
     * Calcula un daño aleatorio entre 2 y 6.
     *
     * @return El daño infligido.
     */
    private int swordSlash() {
        return (int) (Math.random() * 5 + 2);  // Daño aleatorio entre 2 y 6
    }
}