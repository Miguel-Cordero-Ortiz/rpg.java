package rpg.items;

import rpg.entities.Player;
import rpg.enums.ItemType;
import rpg.interfaces.Equipable;

/**
 * Clase base que representa un equipo en el juego.
 */
public abstract class Equipment implements Equipable {
    private String name;          // Nombre del equipo.
    private String description;   // Descripción del equipo.
    private int value;            // Valor del equipo.
    private ItemType itemType;    // Tipo del ítem.

    /**
     * Constructor que inicializa el equipo con nombre, descripción, valor y tipo de ítem.
     *
     * @param name        El nombre del equipo.
     * @param description La descripción del equipo.
     * @param value      El valor del equipo.
     * @param itemType   El tipo de ítem.
     */
    public Equipment(String name, String description, int value, ItemType itemType) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.itemType = itemType;
    }

    /**
     * Obtiene el nombre del equipo.
     *
     * @return El nombre del equipo.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la descripción del equipo.
     *
     * @return La descripción del equipo.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene el valor del equipo.
     *
     * @return El valor del equipo.
     */
    public int getValue() {
        return value;
    }

    /**
     * Obtiene el tipo de ítem del equipo.
     *
     * @return El tipo de ítem.
     */
    public ItemType getItemType() {
        return itemType;
    }

    /**
     * Método abstracto para verificar si el jugador puede equipar el ítem.
     *
     * @param player El jugador que intenta equipar el ítem.
     * @return true si se puede equipar, false en caso contrario.
     */
    @Override
    public abstract boolean canEquip(Player player);
}