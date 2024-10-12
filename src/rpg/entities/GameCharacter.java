package rpg.entities;

import rpg.enums.Stats;
import java.util.HashMap;

/**
 * Clase abstracta GameCharacter que representa a cualquier personaje dentro del juego.
 * Incluye tanto al jugador como a los enemigos, con estadísticas básicas como vida, ataque, defensa, etc.
 */
public class GameCharacter {

    protected String name; // Nombre del personaje
    protected HashMap<Stats, Integer> stats; // Estadísticas del personaje

    /**
     * Constructor que inicializa el nombre del personaje y sus estadísticas vacías.
     * @param name Nombre del personaje.
     */
    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
    }

    /**
     * Verifica si el personaje está vivo, basándose en su valor de HP.
     * @return true si el personaje tiene más de 0 HP, false en caso contrario.
     */
    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    /**
     * Realiza un ataque contra otro personaje del juego, calculando el daño en función del ataque del atacante
     * y la defensa del enemigo. Si el ataque es mayor que la defensa, el enemigo perderá HP,
     * y el daño se muestra en una ventana emergente.
     *
     * @param enemy El enemigo que será atacado.
     */
    public void attack(GameCharacter enemy) {
        String message = "";
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP);

        // Calcula el daño causado
        if (damage > 0) {
            newHP = enemy.getStats().get(Stats.HP) - damage;
            enemy.getStats().put(Stats.HP, Math.max(newHP, 0));
            message += String.format("""
                    %s ataca a %s por %d de daño!
                    %s tiene %d HP restantes.
                    """, this.name, enemyName, damage,
                    enemyName, Math.max(newHP, 0));
        } else {
            message += String.format("""
                    %s ataca a %s pero no causa daño!
                    %s tiene %d HP restantes.
                    """, this.name, enemyName, enemyName, Math.max(newHP, 0));
        }
        // Muestra el mensaje en una ventana emergente
        javax.swing.JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Obtiene el nombre del personaje.
     *
     * @return El nombre del personaje.
     */
    public String getName() {
        return String.format("%s", name);
    }

    /**
     * Obtiene las estadísticas del personaje.
     *
     * @return Un HashMap con las estadísticas del personaje.
     */
    public HashMap<Stats, Integer> getStats() {
        return stats;
    }

    /**
     * Obtiene una representación en formato de cadena de las estadísticas del personaje.
     *
     * @return Una cadena que muestra el nombre, HP, ataque y defensa del personaje.
     */
    public String getStatsString() {
        return String.format("%s: HP = %d, ATTACK = %d, DEFENSE = %d",
                getName(), stats.get(Stats.HP), stats.get(Stats.ATTACK), stats.get(Stats.DEFENSE));
    }
}