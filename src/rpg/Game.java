import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.dragons.BabyDragon;
import rpg.entities.enemies.goblins.RookieGoblin;
import rpg.entities.enemies.skeletons.WeakSkeleton;
import rpg.entities.enemies.slimes.BasicSlime;
import rpg.entities.enemies.zombies.RookieZombie;
import rpg.utils.Randomize;
import javax.swing.*;

/**
 * La clase Game gestiona el flujo principal del juego.
 * Se encarga de inicializar al jugador y seleccionar un enemigo aleatoriamente,
 * mostrar las estadísticas iniciales de ambos personajes y ejecutar el ciclo de combate.
 */
public class Game {

    private Player player;  // El jugador controlado por el usuario.
    private Enemy enemy;    // El enemigo generado aleatoriamente.

    /**
     * Método principal que inicia el juego.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    /**
     * Constructor de la clase Game.
     * Inicializa al jugador con el nombre predeterminado "Jugador" y selecciona aleatoriamente
     * un enemigo de tipo RookieGoblin, BasicSlime, WeakSkeleton, BabyDragon o RookieZombie.
     */
    public Game() {
        this.player = new Player("Jugador");
        int enemyType = Randomize.getRandomInt(1, 5);
        this.enemy = switch (enemyType) {
            case 1 -> new RookieGoblin();
            case 2 -> new BasicSlime();
            case 3 -> new WeakSkeleton();
            case 4 -> new BabyDragon();
            case 5 -> new RookieZombie();
            default -> throw new IllegalStateException("Unexpected value: " + enemyType);
        };
    }

    /**
     * Inicia el combate entre el jugador y el enemigo, mostrando las estadísticas iniciales,
     * realizando los ataques de ambos hasta que uno de ellos sea derrotado.
     */
    public void startGame() {
        // Mostrar estadísticas iniciales
        JOptionPane.showMessageDialog(null, player.getStatsString() + "\n\n" + enemy.getStatsString());

        // Ciclo del juego mientras ambos personajes estén vivos
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);  // El jugador ataca primero
            if (enemy.isAlive()) {
                enemy.attack(player);  // El enemigo ataca si sigue vivo
            }
        }

        // Mostrar el resultado final del combate
        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null, player.getName() + " wins!");
        } else {
            JOptionPane.showMessageDialog(null, enemy.getName() + " wins!");
        }

    }
}