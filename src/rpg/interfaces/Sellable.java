package rpg.interfaces;

/**
 * La interfaz Sellable define los métodos que deben ser implementados
 * por los ítems que pueden ser vendidos por el jugador.
 */
public interface Sellable {

    /**
     * Método para obtener el precio del ítem que se puede vender.
     *
     * @return El precio del ítem.
     */
    int getPrice();

    /**
     * Método para obtener el nombre del ítem que se puede vender.
     *
     * @return El nombre del ítem.
     */
    String getName();
}