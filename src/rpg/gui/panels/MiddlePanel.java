package rpg.gui.panels;

import rpg.gui.MyWindowConstants;
import rpg.utils.ImageCache;
import javax.swing.*;

public class MiddlePanel extends BackgroundPanel {
    @Override
    protected void init() {
        backgroundImage = new ImageIcon(ImageCache.addImage("midPanel", "resources/Fondo_juego1.png"));
        setDimension(MyWindowConstants.CENTER_DIMENSION); // Cambia aquí
        setBorder(MyWindowConstants.EMPTY_BORDER); // Cambia aquí
    }
}
