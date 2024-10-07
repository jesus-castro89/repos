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
    protected int quantity;
    protected int maxQuantity;

    public Misc() {
        super();
        maxQuantity = 99;
    }

    /**
     * Use.
     */
    public abstract void use();

    public boolean isConsumable() {
        return consumable;
    }

    public boolean isStackable() {
        return stackable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
        if (quantity > maxQuantity) {
            quantity = maxQuantity;
        }
    }

    public void decreaseQuantity(int amount) {
        quantity -= amount;
        if (quantity < 0) {
            quantity = 0;
        }
    }
}
