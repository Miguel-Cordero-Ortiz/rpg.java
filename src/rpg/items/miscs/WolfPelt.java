package rpg.items.armors;

import rpg.enums.ItemType;
import rpg.items.Equipment;
import rpg.entities.Player;

/**
 * Clase que representa una armadura específica: Piel de Lobo.
 */
public class WolfPelt extends Equipment {

    /**
     * Constructor de la clase WolfPelt.
     * Inicializa la armadura con nombre, descripción, valor y tipo de ítem.
     */
    public WolfPelt() {
        super("Wolf Pelt", "A warm pelt made from the hide of a wolf.", 15, ItemType.ARMOR);
    }

    /**
     * Verifica si el jugador puede equipar la Piel de Lobo.
     *
     * @param player El jugador que intenta equipar la armadura.
     * @return true si el jugador puede equipar la Piel de Lobo, false en caso contrario.
     */
    @Override
    public boolean canEquip(Player player) {
        // Aquí puedes agregar condiciones específicas para verificar si el jugador puede equipar la armadura.
        return true; // Por defecto, permite equipar.
    }
}