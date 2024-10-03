package rpg.entities.enemies.dragons;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import javax.swing.JOptionPane;

/**
 * Clase BabyDragon que extiende de Enemy.
 * Representa un enemigo de tipo BabyDragon con estadísticas específicas y dos tipos de ataques: aliento de fuego y golpe de cola.
 */
public class BabyDragon extends Enemy {

    /**
     * Constructor que inicializa al BabyDragon con un nombre predefinido y sus estadísticas.
     */
    public BabyDragon() {
        super("Baby Dragon");
        this.stats.put(Stats.MAX_HP, 60); // Vida máxima del Baby Dragon
        this.stats.put(Stats.HP, 60);     // Vida inicial del Baby Dragon
        this.stats.put(Stats.ATTACK, 25); // Valor de ataque del Baby Dragon
        this.stats.put(Stats.DEFENSE, 15); // Valor de defensa del Baby Dragon
    }

    /**
     * Método que implementa el ataque del BabyDragon.
     * Elige aleatoriamente entre dos tipos de ataque: aliento de fuego y golpe de cola.
     *
     * @param enemy El personaje enemigo al que se atacará.
     */
    @Override
    public void attack(GameCharacter enemy) {
        int attackType = (int) (Math.random() * 2) + 1; // Selecciona aleatoriamente 1 o 2 para el tipo de ataque
        int damage = 0;

        switch (attackType) {
            case 1:
                damage = fireBreath(enemy); // Realiza el ataque de aliento de fuego
                break;
            case 2:
                damage = tailWhip(enemy);    // Realiza el ataque de golpe de cola
                break;
        }

        // Muestra el daño realizado y la vida restante del enemigo en ventanas emergentes
        JOptionPane.showMessageDialog(null, this.getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
        JOptionPane.showMessageDialog(null, enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    /**
     * Método privado que realiza el ataque de aliento de fuego del BabyDragon.
     * Calcula el daño considerando el ataque del dragón y la defensa del enemigo.
     *
     * @param enemy El enemigo al que se atacará.
     * @return El daño infligido.
     */
    private int fireBreath(GameCharacter enemy) {
        int damage = Math.max(2, this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE));
        enemy.getStats().put(Stats.HP, Math.max(enemy.getStats().get(Stats.HP) - damage, 0)); // Actualiza la vida del enemigo
        return damage; // Devuelve el daño
    }

    /**
     * Método privado que realiza el ataque de golpe de cola del BabyDragon.
     * Calcula el daño considerando el ataque del dragón y la defensa del enemigo.
     *
     * @param enemy El enemigo al que se atacará.
     * @return El daño infligido.
     */
    private int tailWhip(GameCharacter enemy) {
        int damage = Math.max(2, this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE));
        enemy.getStats().put(Stats.HP, Math.max(enemy.getStats().get(Stats.HP) - damage, 0)); // Actualiza la vida del enemigo
        return damage; // Devuelve el daño
    }
}