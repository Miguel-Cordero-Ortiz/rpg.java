package rpg.gui.panels;

import rpg.gui.MyWindowConstants;
import rpg.utils.ImageCache;
import javax.swing.*;

public class BottomPanel extends BackgroundPanel {
    @Override
    protected void init() {
        backgroundImage = new ImageIcon(ImageCache.addImage("bottomPanel", "resources/Panel_inferior_1.png"));
        setDimension(MyWindowConstants.BOTTOM_DIMENSION); // Cambiar a MyWindowConstants
        setBorder(MyWindowConstants.EMPTY_BORDER); // Cambiar a MyWindowConstants
    }
}
