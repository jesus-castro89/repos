package rpg.gui.panels;

import java.awt.*;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class LeftCornerPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("leftCornerPanel",
                "panels/topLeftCorner.png"));
        setDimension(WindowConstants.CORNER_DIMENSION);
    }
}
