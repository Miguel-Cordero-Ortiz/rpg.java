package rpg.utils;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ImageCache {
    private static Map<String, String> imagePaths = new HashMap<>();

    public static String addImage(String name, String path) {
        imagePaths.put(name, path);
        return path;
    }

    public static ImageIcon getImage(String name) {
        String path = imagePaths.get(name);
        if (path != null) {
            return new ImageIcon(path);
        }
        return null; // O puedes lanzar una excepción si prefieres
    }
}
