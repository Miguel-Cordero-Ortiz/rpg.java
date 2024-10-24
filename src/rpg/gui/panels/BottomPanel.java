package rpg.gui.panels;

import rpg.gui.panels.BackgroundPanel;
import rpg.gui.WindowConstants;
import rpg.utils.ImageCache;

import javax.swing.*;

public class BottomPanel extends BackgroundPanel {
    @Override
    protected void init() {
        backgroundImage = new ImageIcon(ImageCache.addImage("bottomPanel", "resources/info_juego1.png"));
        setDimension(WindowConstants.BOTTOM_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }

}