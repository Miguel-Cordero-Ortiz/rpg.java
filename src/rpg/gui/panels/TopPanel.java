package rpg.gui.panels;

import rpg.gui.MyWindowConstants;
import rpg.utils.ImageCache;
import javax.swing.*;

public class TopPanel extends BackgroundPanel {
    @Override
    protected void init() {
        // Cargamos la imagen desde el caché, usando el nombre único para TopPanel
        backgroundImage = new ImageIcon(ImageCache.addImage("topPanel", "resources/Pared_ladrillos_1.png"));

        // Ajustamos las dimensiones del panel con la constante establecida para TopPanel
        setDimension(MyWindowConstants.TOP_DIMENSION); // Cambiar a MyWindowConstants

        // Configuramos el borde (sin borde, en este caso, pero podrías ajustarlo según sea necesario)
        setBorder(MyWindowConstants.EMPTY_BORDER); // Cambiar a MyWindowConstants
    }
}
