package rpg.items.armors.helmet;

import rpg.enums.ArmorType;
import rpg.items.armors.Armor;

/**
 * La clase Helmet es una representación básica de un casco en el juego.
 */
public abstract class Helmet extends Armor {

    /**
     * Constructor de la clase Helmet.
     *
     * @param name        El nombre del casco.
     * @param description La descripción del casco.
     * @param defense     El valor de defensa del casco.
     * @param price       El precio del casco.
     */
    public Helmet(String name, String description, int defense, int price) {
        super(name, description, defense, price); // Llama al constructor de Armor correctamente
    }

    @Override
    public ArmorType getArmorType() {
        return ArmorType.HELMET; // Retorna el tipo de armadura
    }


}