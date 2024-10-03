package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.enums.Stats;
/**
 * Clase abstracta Enemy que extiende de GameCharacter.
 * Representa a cualquier enemigo en el juego, proporcionando un constructor básico y la necesidad de que las subclases implementen el método de ataque.
 */
public abstract class Enemy extends GameCharacter {
    /**
     * Constructor que inicializa el nombre del enemigo llamando al constructor de la clase GameCharacter.
     * @param name Nombre del enemigo.
     */
    public Enemy(String name) {
        super(name); // Llama al constructor de GameCharacter con el nombre
    }
    /**
     * Método abstracto de ataque que deberá ser implementado por las subclases.
     * Este método define cómo un enemigo atacará a otro personaje en el juego.
     *
     * @param enemy El personaje que será atacado.
     */
    @Override
    public void attack(GameCharacter enemy) {
        // Este método debe ser implementado por las subclases
    }
}