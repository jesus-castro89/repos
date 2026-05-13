package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.gui.labels.IconLabel;
import rpg.items.Item;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class ItemDisplay extends BackgroundPanel {
    private JButton sellButton;
    private JButton throwButton;
    private JLabel itemIcon;
    private JLabel itemLabel;
    private JPanel mainPanel;

    public ItemDisplay(Item item) {
        super();
        add(mainPanel);
        itemIcon.setIcon(item.getIcon());
        itemLabel.setFont(UIConstants.LABEL_FONT);
        itemLabel.setText(item.getName());
    }

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("itemPanel",
                "panels/itemHolder.png"));
        setDimension(new Dimension(397, 97));
        setBorder(UIConstants.EMPTY_BORDER);
    }

    private void createUIComponents() {
        itemIcon=new IconLabel(ImageCache.getImageIcon("woodHelmet"));
    }
}
