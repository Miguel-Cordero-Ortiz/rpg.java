/**
 * Clase de utilidad para generar números aleatorios.
 */
package rpg.utils;

import java.util.Random;

public class Randomize {

    private static final Random random = new Random(); // Generador de números aleatorios.
    /**
     * Genera un número entero aleatorio entre dos valores dados.
     * @param min El valor mínimo (inclusive).
     * @param max El valor máximo (inclusive).
     * @return Un número entero aleatorio entre min y max.
     */
    public static int getRandomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}