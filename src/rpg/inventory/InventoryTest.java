package rpg.inventory;

import rpg.items.Item;
import rpg.items.armors.Armor;
import rpg.items.armors.helmet.*;
import rpg.items.armors.chestplate.*;

import javax.swing.JOptionPane;

/**
 * Clase de prueba para el inventario.
 * Esta clase se encarga de crear un inventario y agregar ítems de prueba.
 * Muestra los detalles de los ítems en una ventana emergente.
 */
public class InventoryTest {
    public static void main(String[] args) {
        // Crear un nuevo inventario
        Inventory inventory = new Inventory();

        // Crear instancias de IronHelmet y WoodHelmet con los parámetros necesarios
        IronHelmet ironHelmet = new IronHelmet("Iron Helmet", "A sturdy iron helmet.", 5, 50);
        WoodHelmet woodHelmet = new WoodHelmet("Wood Helmet", "A basic wooden helmet.", 2, 20);
        DiamondHelmet diamondHelmet = new DiamondHelmet("Diamond Helmet", "A basic diamond helmet.", 2, 20);
        GoldHelmet goldHelmet = new GoldHelmet("Gold Helmet", "A raryty gold helmet.", 2, 20);
        LeatherHelmet leatherHelmet = new LeatherHelmet("Leather Helmet", "A small leather helmet.", 2, 20);

        // Agregar los ítems al inventario
        inventory.addItem(ironHelmet);
        inventory.addItem(woodHelmet);
        inventory.addItem(diamondHelmet);
        inventory.addItem(goldHelmet);
        inventory.addItem(leatherHelmet);

        // Mostrar detalles de todos los ítems en el inventario
        StringBuilder inventoryDetails = new StringBuilder("Ítems en el Inventario:\n");

        for (Item item : inventory.getItems()) {
            inventoryDetails.append("Ítem: ").append(item.getName())
                    .append("\nDescripción: ").append(item.getDescription())
                    .append("\nPrecio: ").append(item.getPrice());

            // Verificar si el ítem es una instancia de Armor antes de llamar a getArmorType()
            if (item instanceof Armor armor) { // Hacer el casting a Armor directamente
                inventoryDetails.append("\nTipo de Armadura: ").append(armor.getArmorType());
            }

            inventoryDetails.append("\n\n");
        }

        // Mostrar los detalles del inventario en una ventana emergente
        JOptionPane.showMessageDialog(null, inventoryDetails.toString(), "Detalles del Inventario", JOptionPane.INFORMATION_MESSAGE);
    }
}