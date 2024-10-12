package rpg.items;

import rpg.enums.ItemType;

/**
 * Clase base para los ítems del juego.
 */
public abstract class Item {
    private String name;          // Nombre del ítem.
    private String description;   // Descripción del ítem.
    private int price;            // Precio del ítem.
    private ItemType itemType;    // Tipo del ítem.

    /**
     * Constructor de la clase Item.
     *
     * @param name        Nombre del ítem.
     * @param description Descripción del ítem.
     * @param price      Precio del ítem.
     * @param itemType   Tipo del ítem.
     */
    public Item(String name, String description, int price, ItemType itemType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.itemType = itemType; // Asegúrate de incluir itemType
    }

    /**
     * Devuelve el nombre del ítem.
     *
     * @return Nombre del ítem.
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve la descripción del ítem.
     *
     * @return Descripción del ítem.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Devuelve el precio del ítem.
     *
     * @return Precio del ítem.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Devuelve el tipo del ítem.
     *
     * @return Tipo del ítem.
     */
    public ItemType getItemType() {
        return itemType; // Método para obtener el tipo de ítem.
    }
}