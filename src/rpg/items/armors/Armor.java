package rpg.items.armors;

import rpg.enums.ArmorType;
import rpg.enums.ItemType;
import rpg.items.Item;
import rpg.interfaces.Equipable;
import rpg.entities.Player;

/**
 * Clase base para las armaduras en el juego.
 */
public abstract class Armor extends Item implements Equipable {
    private int defense; // Valor de defensa de la armadura
    private int price;   // Precio de la armadura

    /**
     * Constructor de Armor que requiere todos los parámetros.
     *
     * @param name        El nombre de la armadura.
     * @param description La descripción de la armadura.
     * @param defense     El valor de defensa de la armadura.
     * @param price       El precio de la armadura.
     */
    public Armor(String name, String description, int defense, int price) {
        super(name, description, price, ItemType.ARMOR); // Llama al constructor de Item correctamente
        this.defense = defense;
    }

    /**
     * Constructor de Armor que solo requiere el nombre y la descripción.
     *
     * @param name        El nombre de la armadura.
     * @param description La descripción de la armadura.
     */
    public Armor(String name, String description) {
        super(name, description, 0, ItemType.ARMOR); // Llama al constructor de Item con precio por defecto
        this.defense = 0; // Valor por defecto
    }

    /**
     * Método para obtener la defensa de la armadura.
     *
     * @return El valor de defensa de la armadura.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Método para obtener el precio de la armadura.
     *
     * @return El precio de la armadura.
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Método abstracto para obtener el tipo de armadura.
     *
     * @return El tipo de armadura como ArmorType.
     */
    public abstract ArmorType getArmorType();

    /**
     * Método que determina si el jugador puede equipar este ítem.
     *
     * @param player El jugador que intenta equipar el ítem.
     * @return true si el jugador puede equipar el ítem, false en caso contrario.
     */
    @Override
    public boolean canEquip(Player player) {
        // Aquí puedes implementar la lógica específica que determines para que un jugador pueda equipar esta armadura
        return true; // Por defecto, todas las armaduras son equipables; personaliza según tu necesidad.
    }
}