package rpg.gui.panels;
import rpg.gui.panels.BackgroundPanel;
import rpg.gui.WindowConstants;
import rpg.utils.ImageCache;

import javax.swing.*;

public class TopPanel extends BackgroundPanel {
    @Override
    protected void init() {
        backgroundImage = new ImageIcon(ImageCache.addImage("topPanel", "resources/Panel_juego1.png"));
        setDimension(WindowConstants.TOP_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }

}