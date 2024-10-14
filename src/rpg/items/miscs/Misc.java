package rpg.items.miscs;

import rpg.enums.ItemType;
import rpg.items.Item;

/**
 * La clase Misc representa un ítem misceláneo en el juego.
 */
public class Misc extends Item {

    /**
     * Constructor de Misc.
     * Inicializa el ítem misceláneo con nombre, descripción y precio.
     *
     * @param name El nombre del ítem.
     * @param description La descripción del ítem.
     * @param price El precio del ítem.
     */
    public Misc(String name, String description, int price) {
        super(name, description, price, ItemType.MISC); // Llama al constructor de Item con los parámetros adecuados
    }

    /**
     * Representa el ítem misceláneo como una cadena.
     *
     * @return Una representación en forma de cadena del ítem misceláneo.
     */
    @Override
    public String toString() {
        return "Misc{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}