package rpg.entities;

import rpg.enums.Stats;
import rpg.exceptions.ItemNotFoundException;
import rpg.inventory.Inventory;
import rpg.items.Item;
import rpg.items.miscs.Misc;

import javax.swing.*;
import java.util.HashMap;

/**
 * The type Player.
 */
public class Player extends GameCharacter {

    private final Inventory inventory;

    /**
     * Instantiates a new Player.
     *
     * @param name the name
     */
    public Player(String name) {

        super(name);
        inventory = new Inventory();
    }

    /**
     * Función sobrescrita que inicializa las características
     * del personaje.
     */
    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item) {

        if (item instanceof Misc misc) {
            if (misc.isStackable()) {
                boolean found = false;
                for (Item i : inventory.getItems()) {
                    if (i.getName().equals(misc.getName())) {
                        misc.increaseQuantity(1);
                        inventory.removeItem(i);
                        inventory.addItem(misc);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    inventory.addItem(item);
                }
            } else {
                inventory.addItem(item);
            }
        } else {
            inventory.addItem(item);
        }
    }

    public void removeItemFromInventory(Item item) {

        if (item instanceof Misc misc) {
            if (misc.isStackable()) {
                for (Item i : inventory.getItems()) {
                    if (i.getName().equals(item.getName())) {
                        misc.decreaseQuantity(1);
                        if (misc.getQuantity() == 0) {
                            inventory.removeItem(i);
                        }
                        break;
                    }
                }
            }
        }
    }

    public void sellItem(Item item) {

        try {
            Item getItem = inventory.getItem(item);
            if (getItem instanceof Misc misc) {
                if (misc.isStackable()) {
                    if (misc.getQuantity() > 1) {
                        misc.decreaseQuantity(1);
                    } else {
                        inventory.removeItem(item);
                    }
                }
            } else {
                inventory.removeItem(getItem);
            }
        } catch (ItemNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void showInventory() {

        StringBuilder content = new StringBuilder("Inventory: \n");
        String format = """
                Name: %s, Price: %d
                Description: %s
                """;
        String formatQuantity = """
                Name: %s, Price: %d, Quantity: %d
                Description: %s
                """;
        for (Item item : inventory.getItems()) {

            if (item instanceof Misc misc) {
                if (misc.isStackable()) {
                    content.append(String.format(formatQuantity, item.getName(),
                            item.getPrice(), misc.getQuantity(), item.getDescription()));
                } else {
                    content.append(String.format(format, item.getName(), item.getPrice(),
                            item.getDescription()));
                }
            } else {
                content.append(String.format(format, item.getName(), item.getPrice(),
                        item.getDescription()));
            }
        }
        JOptionPane.showMessageDialog(null, content.toString());
    }
}
