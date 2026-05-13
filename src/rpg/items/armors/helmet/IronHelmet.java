package rpg.items.armors.helmet;

import rpg.enums.Stats;
import rpg.enums.WearType;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

/**
 * The type Iron helmet.
 */
public class IronHelmet extends WoodHelmet {

    /**
     * Instantiates a new Iron helmet.
     */
    public IronHelmet() {

        super();
        this.wearType = WearType.HEAD;
        this.name = "Iron Helmet";
        this.description = "Un casco de hierro. No es muy resistente, pero tiene una dureza superior a la madera.";
        this.stats.put(Stats.DEFENSE, 5);
        ImageCache.addImage("ironHelmet", "items/leather_armor.png");
        iconName = "ironHelmet";
    }

    @Override
    public void protect() {
        System.out.println("El casco de hierro te protege de un golpe y resiste.");
    }
}
