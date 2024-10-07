package rpg.inventory;

import rpg.entities.Player;
import rpg.items.Item;
import rpg.items.armors.helmet.IronHelmet;
import rpg.items.armors.helmet.WoodHelmet;
import rpg.items.miscs.WolfPelt;

import javax.swing.*;
import java.awt.*;

/**
 * The type Inventory test.
 */
public class InventoryTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        UIManager.put("OptionPane.messageFont",
                new Font("Arial", Font.BOLD, 18));
        Player player = new Player("Player 1");
        Item ironHelmet = new IronHelmet();
        Item woodHelmet = new WoodHelmet();
        player.addItemToInventory(ironHelmet);
        player.addItemToInventory(woodHelmet);
        player.addItemToInventory(new WolfPelt());
        player.showInventory();
        player.addItemToInventory(new WolfPelt());
        player.showInventory();
        player.addItemToInventory(new WoodHelmet());
        player.showInventory();
    }
}
