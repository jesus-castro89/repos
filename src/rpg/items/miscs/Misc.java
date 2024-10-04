package rpg.items.miscs;

import rpg.items.Item;

/**
 * The type Misc.
 */
public abstract class Misc extends Item {

    /**
     * The Consumable.
     */
    protected boolean consumable;
    /**
     * The Stackable.
     */
    protected boolean stackable;

    /**
     * Use.
     */
    public abstract void use();
}
