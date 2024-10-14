import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.dragons.BabyDragon;
import rpg.entities.enemies.goblins.RookieGoblin;
import rpg.entities.enemies.skeletons.WeakSkeleton;
import rpg.entities.enemies.slimes.BasicSlime;
import rpg.entities.enemies.zombies.RookieZombie;
import rpg.interfaces.Equipable;
import rpg.inventory.Inventory;
import rpg.items.Item;
import rpg.items.armors.Armor;
import rpg.items.armors.helmet.IronHelmet;
import rpg.items.armors.helmet.WoodHelmet;
import rpg.utils.Randomize;

import javax.swing.*;

/**
 * La clase Game representa el juego principal, donde se controla al jugador y se generan enemigos aleatorios.
 * Maneja la lógica del juego, incluyendo el inicio del juego, la interacción con el inventario y las acciones del jugador.
 */
public class Game {

    private Player player;      // El jugador controlado por el usuario.
    private Enemy enemy;        // El enemigo generado aleatoriamente.
    private Inventory inventory; // Inventario del jugador.

    /**
     * Método principal que inicia el juego.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    /**
     * Constructor de la clase Game.
     * Inicializa el jugador, el inventario y genera un enemigo aleatorio.
     */
    public Game() {
        this.player = new Player("Jugador");
        this.inventory = new Inventory(); // Inicializar el inventario
        int enemyType = Randomize.getRandomInt(1, 5);
        this.enemy = switch (enemyType) {
            case 1 -> new RookieGoblin();
            case 2 -> new BasicSlime();
            case 3 -> new WeakSkeleton();
            case 4 -> new BabyDragon();
            case 5 -> new RookieZombie();
            default -> throw new IllegalStateException("Unexpected value: " + enemyType);
        };

        // Añadir armaduras al inventario
        inventory.addItem(new IronHelmet("Iron Helmet", "A sturdy iron helmet.", 5, 100));
        inventory.addItem(new WoodHelmet("Wood Helmet", "A simple wooden helmet.", 2, 50));
    }

    /**
     * Inicia el juego mostrando las estadísticas del jugador y del enemigo,
     * y presenta un menú de acciones hasta que uno de los dos pierda.
     */
    public void startGame() {
        JOptionPane.showMessageDialog(null, player.getStatsString() + "\n\n" + enemy.getStatsString());

        while (player.isAlive() && enemy.isAlive()) {
            String[] options = {"Ver Inventario", "Atacar"};
            int choice = JOptionPane.showOptionDialog(null, "¿Qué deseas hacer?", "Menú de acción",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                showInventory();
            } else if (choice == 1) {
                player.attack(enemy);
                if (enemy.isAlive()) {
                    enemy.attack(player);
                }
            }
        }

        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null, player.getName() + " gana!");
        } else {
            JOptionPane.showMessageDialog(null, enemy.getName() + " gana!");
        }
    }

    /**
     * Muestra el inventario del jugador y permite equipar o vender ítems.
     */
    private void showInventory() {
        StringBuilder inventoryDisplay = new StringBuilder("Inventario:\n");
        for (int i = 0; i < inventory.getItems().size(); i++) {
            Item item = inventory.getItems().get(i);
            inventoryDisplay.append(i + 1).append(". ").append(item.getName()).append(": ")
                    .append(item.getDescription()).append("\n");
        }
        inventoryDisplay.append("Selecciona un ítem para equipar o vender (0 para salir):");

        String choiceString = JOptionPane.showInputDialog(inventoryDisplay.toString());

        if (choiceString != null && !choiceString.trim().isEmpty()) {
            int choice = Integer.parseInt(choiceString);

            if (choice == 0) {
                return; // Regresa al menú de acciones
            }

            if (choice > 0 && choice <= inventory.getItems().size()) {
                Item item = inventory.getItems().get(choice - 1);
                String[] actions = {"Equipar", "Vender"};
                int actionChoice = JOptionPane.showOptionDialog(null, "¿Qué deseas hacer con " + item.getName() + "?",
                        "Opciones de Item", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, actions, actions[0]);

                if (actionChoice == 0) { // Equipar
                    if (item instanceof Equipable equipableItem) {
                        if (equipableItem.canEquip(player)) {
                            player.setArmor((Armor) equipableItem);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se puede equipar este ítem.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Este ítem no es equipable.");
                    }
                } else if (actionChoice == 1) { // Vender
                    inventory.removeItem(item);
                    JOptionPane.showMessageDialog(null, item.getName() + " ha sido vendido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selección no válida.");
            }
        }
    }
}