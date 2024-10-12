import rpg.items.Inventory;
import rpg.items.armors.Armor;
import rpg.items.armors.armor.WoodArmor;
import rpg.items.miscs.Misc;
import rpg.items.miscs.WolfPelt;

public class InventoryTest {

        public static void main(String[] args) {

            Inventory inventory = new Inventory(10);

            Armor armor = new WoodArmor();
            inventory.addItem(armor);

            Misc misc = new WolfPelt();
            inventory.addItem(misc);

            System.out.println("Armors in inventory:");
            for (Armor a : inventory.getArmors()) {
                System.out.println(a.getName());
            }

            System.out.println("Miscs in inventory:");
            for (Misc m : inventory.getMiscs()) {
                System.out.println(m.getName());
            }
        }
}
