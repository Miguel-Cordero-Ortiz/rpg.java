package rpg.inventory;

import rpg.items.Item;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Inventory representa el inventario del jugador,
 * permitiendo añadir, eliminar y gestionar ítems.
 */
public class Inventory {
    private List<Item> items; // Lista de ítems en el inventario

    /**
     * Constructor de la clase Inventory.
     * Inicializa la lista de ítems.
     */
    public Inventory() {
        items = new ArrayList<>();
    }

    /**
     * Añade un ítem al inventario.
     *
     * @param item El ítem a añadir.
     */
    public void addItem(Item item) {
        items.add(item);
        JOptionPane.showMessageDialog(null, item.getName() + " ha sido añadido al inventario.");
    }

    /**
     * Elimina un ítem del inventario.
     *
     * @param item El ítem a eliminar.
     */
    public void removeItem(Item item) {
        if (items.remove(item)) {
            JOptionPane.showMessageDialog(null, item.getName() + " ha sido eliminado del inventario.");
        } else {
            JOptionPane.showMessageDialog(null, "El ítem " + item.getName() + " no se encuentra en el inventario.");
        }
    }

    /**
     * Devuelve la lista de ítems en el inventario.
     *
     * @return Lista de ítems.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Muestra los ítems en el inventario.
     */
    public void showInventory() {
        if (items.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El inventario está vacío.");
        } else {
            StringBuilder inventoryList = new StringBuilder("Ítems en el inventario:\n");
            for (Item item : items) {
                inventoryList.append("- ").append(item.getName()).append("\n");
            }
            JOptionPane.showMessageDialog(null, inventoryList.toString());
        }
    }
}