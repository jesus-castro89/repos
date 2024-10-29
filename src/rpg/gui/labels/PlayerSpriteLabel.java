package rpg.gui.labels;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class PlayerSpriteLabel extends PortraitLabel {

    public PlayerSpriteLabel() {

        super();
    }

    @Override
    public void initComponents() {
        ImageCache.addImage("playerSprite", "player/player.png");
        icon = ImageCache.getImageIcon("playerSprite");
        setPreferredSize(new Dimension(icon.getIconWidth(),
                icon.getIconHeight()));
        setIcon(icon);
    }
}
