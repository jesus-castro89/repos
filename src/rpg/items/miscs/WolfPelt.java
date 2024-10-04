package rpg.items.miscs;

import rpg.enums.ItemType;

/**
 * The type Wolf pelt.
 */
public class WolfPelt extends Misc {

    @Override
    protected void initItem() {
        this.type = ItemType.MISC;
        this.name = "Piel de lobo";
        this.description = "Una piel de lobo. Se puede vender por un buen precio.";
        this.price = 50;
        this.consumable = false;
        this.stackable = true;
    }

    @Override
    public void use() {
        System.out.println("No puedes usar una piel de lobo.");
    }
}
