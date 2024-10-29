package rpg.entities.enemies.goblins;

import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class GoblinGeneral extends RookieGoblin {

    public GoblinGeneral() {

        super();
        setName("Goblin General");
        ImageCache.addImage("goblin_general", "enemies/Zodiac Virgo.png");
    }

    @Override
    public ImageIcon getSprite() {
        return new ImageIcon(ImageCache.getImage("goblin_general"));
    }
}
