package rpg.inventory;

import rpg.items.Item;
import rpg.items.armors.Armor;
import rpg.items.miscs.Misc;

import java.util.ArrayList;

/**
 * The type Inventory.
 */
public class Inventory {

    /**
     * The Items.
     */
    private ArrayList<Item> items;
    /**
     * The Capacity.
     */
    private int capacity;

    /**
     * Instantiates a new Inventory.
     *
     * @param capacity the capacity
     */
    public Inventory(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
        } else {
            System.out.println("Inventory is full");
        }
    }

    /**
     * Remove item.
     *
     * @param item the item
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Gets item.
     *
     * @param index the index
     */
    public void getItem(int index) {
        items.get(index);
    }

    /**
     * Gets item count.
     */
    public void getItemCount() {
        items.size();
    }

    /**
     * Is full boolean.
     *
     * @return the boolean
     */
    public boolean isFull() {
        return items.size() == capacity;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Clear.
     */
    public void clear() {
        items.clear();
    }

    /**
     * Increase capacity.
     *
     * @param amount the amount
     */
    public void increaseCapacity(int amount) {
        capacity += amount;
        items.ensureCapacity(capacity);
    }

    /**
     * Gets armors.
     *
     * @return the armors
     */
    public ArrayList<Armor> getArmors() {

        ArrayList<Armor> armors = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Armor) {
                armors.add((Armor) item);
            }
        }
        return armors;
    }

    /**
     * Gets miscs.
     *
     * @return the miscs
     */
    public ArrayList<Misc> getMiscs() {

        ArrayList<Misc> miscs = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Misc) {
                miscs.add((Misc) item);
            }
        }
        return miscs;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public ArrayList<Item> getItems() {
        return items;
    }
}
