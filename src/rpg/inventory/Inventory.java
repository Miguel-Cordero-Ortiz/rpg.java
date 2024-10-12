package rpg.items;

import rpg.items.armors.Armor;
import rpg.items.armors.armor.WoodArmor;
import rpg.items.miscs.Misc;
import rpg.items.miscs.WolfPelt;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;
    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
        } else {
            System.out.println("Inventory is full");
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public void getItemCount() {
        items.size();
    }

    public boolean isFull() {
        return items.size() == capacity;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public void increaseCapacity(int amount) {
        capacity += amount;
        items.ensureCapacity(capacity);
    }

    public ArrayList<Armor> getArmors() {

        ArrayList<Armor> armors = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Armor) {
                armors.add((Armor) item);
            }
        }
        return armors;
    }

    public ArrayList<Misc> getMiscs() {

        ArrayList<Misc> miscs = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Misc) {
                miscs.add((Misc) item);
            }
        }
        return miscs;
    }
    public class Main {

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
}