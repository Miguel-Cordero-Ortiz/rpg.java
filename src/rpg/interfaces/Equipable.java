package rpg.interfaces;

import rpg.entities.Player;

/**
 * La interfaz Equipable define los métodos que deben ser implementados
 * por los ítems que pueden ser equipados por los jugadores.
 */
public interface Equipable {

    /**
     * Método para obtener el nombre del ítem.
     *
     * @return El nombre del ítem.
     */
    String getName();

    /**
     * Método para obtener la descripción del ítem.
     *
     * @return La descripción del ítem.
     */
    String getDescription();

    /**
     * Método que determina si el jugador puede equipar este ítem.
     *
     * @param player El jugador que intenta equipar el ítem.
     * @return true si el jugador puede equipar el ítem, false en caso contrario.
     */
    boolean canEquip(Player player);
}