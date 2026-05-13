package rpg.gui.internalFrames;

import rpg.gui.UIConstants;
import rpg.gui.panels.InternPanel;
import rpg.gui.panels.ItemDisplay;
import rpg.gui.panels.ItemDisplayPanel;
import rpg.gui.ui.TransparentFrameUI;
import rpg.gui.windows.MainWindow;
import rpg.items.Item;
import rpg.items.armors.helmet.IronHelmet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InventoryFrame extends JInternalFrame {

    private JPanel mainPanel;
    private JScrollPane scrollPanel;
    private JPanel displayPanel;
    private MainWindow window;
    private Dimension dimension;

    public InventoryFrame(MainWindow window) {

        this.window = window;
        setContentPane(mainPanel);
        scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        setLayouts();
        setBorder(null);
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        addItem(new IronHelmet());
        pack();
        dimension = getSize();
        dimension.height+=53;
        setUI(new TransparentFrameUI(this, dimension));
        pack();
    }

    private void createUIComponents() {
        int displayHeight = 550;
        mainPanel = new InternPanel(910, displayHeight);
        mainPanel.setBorder(new EmptyBorder(10, 5, 10, 5));
    }

    private void setLayouts() {

        GridBagLayout layout = new GridBagLayout();
        setBorder(BorderFactory.createEmptyBorder(6, 8, 8, 8));
        layout.columnWidths = new int[]{397};
        layout.rowHeights = new int[]{97};
        displayPanel.removeAll();
        displayPanel.setLayout(layout);
        displayPanel.setOpaque(false);
        scrollPanel.setOpaque(false);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.getViewport().setOpaque(false);
        scrollPanel.getVerticalScrollBar().setOpaque(false);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    protected void addItem(Item item) {

        addItemComponent(new ItemDisplay(item));
    }

    private void addItemComponent(ItemDisplay detail) {

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = displayPanel.getComponentCount() % 2;
        c.gridy = displayPanel.getComponentCount() / 2;
        c.fill = GridBagConstraints.CENTER;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.weighty = 1;
        displayPanel.add(detail, c);
        displayPanel.revalidate();
        displayPanel.repaint();
    }
}
