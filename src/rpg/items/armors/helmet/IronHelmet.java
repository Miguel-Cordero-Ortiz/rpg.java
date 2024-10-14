package rpg.items.armors.helmet;

import rpg.enums.ArmorType;

/**
 * Representación de un casco de hierro.
 */
public class IronHelmet extends Helmet {

    /**
     * Constructor de IronHelmet.
     *
     * @param name        El nombre del casco.
     * @param description La descripción del casco.
     * @param defense     El valor de defensa del casco.
     * @param price       El precio del casco.
     */
    public IronHelmet(String name, String description, int defense, int price) {
        super(name, description, defense, price); // Llama al constructor de Helmet
    }

    /**
     * Obtiene el tipo de armadura.
     *
     * @return El tipo de armadura como ArmorType.
     */
    @Override
    public ArmorType getArmorType() {
        return ArmorType.HELMET; // Retorna el tipo de armadura
    }
}