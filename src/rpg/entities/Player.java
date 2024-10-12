package rpg.entities;

import rpg.enums.Stats;
import rpg.items.armors.Armor;
import rpg.interfaces.Equipable;
import javax.swing.JOptionPane;

/**
 * La clase Player representa al jugador controlado por el usuario.
 * Hereda de GameCharacter y tiene su propio conjunto de estadísticas y métodos de ataque.
 */
public class Player extends GameCharacter {
    private String name; // Nombre del jugador.
    private Armor armor; // Armadura equipada actualmente.

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

        // Aplica daño al enemigo
        enemy.getStats().put(Stats.HP, Math.max(enemy.getStats().get(Stats.HP) - damage, 0));
        JOptionPane.showMessageDialog(null, name + " " + attackType + " y hace " + damage + " de daño a " + enemy.getName() + "!");
        JOptionPane.showMessageDialog(null, enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " HP restantes.");
    }

    // Métodos de ataque que generan daño aleatorio
    private int slash() {
        return (int) (Math.random() * 10 + 5);  // Daño entre 5 y 15
    }

    private int stab() {
        return (int) (Math.random() * 10 + 5);  // Daño entre 5 y 15
    }

    private int overhead() {
        return (int) (Math.random() * 10 + 5);  // Daño entre 5 y 15
    }

    /**
     * Método para equipar una armadura.
     * @param armor La armadura que se desea equipar.
     */
    public void setArmor(Armor armor) {
        // Verificar si la armadura es equipable
        if (armor instanceof Equipable equipable && equipable.canEquip(this)) {
            // Verificar si el jugador ya tiene esta armadura equipada
            if (this.armor == armor) {
                JOptionPane.showMessageDialog(null, "El jugador ya tiene equipado " + armor.getName() + ".");
                return; // No hacer nada más si es la misma armadura
            }

            // Remover los efectos de la armadura actual si hay alguna equipada
            if (this.armor != null) {
                this.stats.put(Stats.DEFENSE, this.stats.get(Stats.DEFENSE) - this.armor.getDefense());
                JOptionPane.showMessageDialog(null, name + " ha dejado de usar " + this.armor.getName());
            }

            // Establecer la nueva armadura
            this.armor = armor;
            this.stats.put(Stats.DEFENSE, this.stats.get(Stats.DEFENSE) + armor.getDefense());
            JOptionPane.showMessageDialog(null, name + " ha equipado " + armor.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Este ítem no es equipable o no puedes equiparlo.");
        }
    }

    /**
     * Obtiene el nombre del jugador.
     * @return El nombre del jugador.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la armadura actualmente equipada por el jugador.
     * @return La armadura equipada.
     */
    public Armor getArmor() {
        return armor;
    }
}