/**
 * La clase Player representa al jugador controlado por el usuario.
 * Hereda de GameCharacter y tiene su propio conjunto de estadísticas y métodos de ataque.
 */
package rpg.entities;

import rpg.enums.Stats;
import javax.swing.JOptionPane;

public class Player extends GameCharacter {
    private String name; // Nombre del jugador.
    /**
     * Constructor que inicializa al jugador con un nombre y estadísticas predeterminadas.
     * @param name El nombre del jugador.
     */
    public Player(String name) {
        super(name); // Llama al constructor de GameCharacter con el nombre
        this.name = name;
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.ATTACK, 20);
        this.stats.put(Stats.DEFENSE, 10);
    }
    /**
     * Realiza un ataque al enemigo, eligiendo aleatoriamente entre varios tipos de ataque.
     * @param enemy El enemigo a atacar.
     */
    @Override
    public void attack(GameCharacter enemy) {
        String attackType = "";
        int damage = 0;

        int attackChoice = (int) (Math.random() * 3); // Elección aleatoria del tipo de ataque
        switch (attackChoice) {
            case 0:
                damage = slash();  // Ataque tipo corte
                attackType = "lanza un corte con su espada";
                break;
            case 1:
                damage = stab();  // Ataque tipo estocada
                attackType = "lanza una estocada";
                break;
            case 2:
                damage = overhead();  // Ataque tipo golpe vertical
                attackType = "lanza un ataque vertical";
                break;
        }

        enemy.getStats().put(Stats.HP, Math.max(enemy.getStats().get(Stats.HP) - damage, 0));
        JOptionPane.showMessageDialog(null, name + " " + attackType + " y hace " + damage + " de daño a " + enemy.getName() + "!");
        JOptionPane.showMessageDialog(null, enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " HP restantes.");
    }

    private int slash() {
        return (int) (Math.random() * 10 + 5);  // Daño entre 5 y 15
    }

    private int stab() {
        return (int) (Math.random() * 10 + 5);  // Daño entre 5 y 15
    }

    private int overhead() {
        return (int) (Math.random() * 10 + 5);  // Daño entre 5 y 15
    }

    public String getName() {
        return name;
    }
}