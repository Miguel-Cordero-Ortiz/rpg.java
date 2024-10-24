package rpg.gui.panels;

import rpg.gui.panels.BackgroundPanel;
import rpg.gui.WindowConstants;
import rpg.utils.ImageCache;

import javax.swing.*;

public class MiddlePanel extends BackgroundPanel {
    @Override
    protected void init() {
        backgroundImage = new ImageIcon(ImageCache.addImage("midPanel", "resources/Fondo_juego1.png"));
        setDimension(WindowConstants.MIDDLE_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }

}