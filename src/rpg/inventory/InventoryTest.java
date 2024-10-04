package rpg.inventory;

import rpg.items.Item;
import rpg.items.armors.helmet.IronHelmet;
import rpg.items.armors.helmet.WoodHelmet;

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
        Inventory inventory = new Inventory(10);
        inventory.addItem(new WoodHelmet());
        inventory.addItem(new IronHelmet());
        for (Item item : inventory.getArmors()) {
            switch (item.getClass().getSimpleName()) {
                case "WoodHelmet":
                    System.out.println("Wood helmet found");
                    ((WoodHelmet) item).protect();
                    break;
                case "IronHelmet":
                    System.out.println("Iron helmet found");
                    ((IronHelmet) item).protect();
                    break;
                default:
                    System.out.println("Unknown item found");
                    break;
            }
        }
        inventory.getItemCount();
        inventory.isFull();
        System.out.println("Investory Test Completed");
    }
}
