package rpg.gui.labels;

import rpg.gui.ui.GameLabelUI;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractLabel extends JLabel {

    protected ImageIcon icon;

    public AbstractLabel() {
        initComponents();
        setUI(new GameLabelUI(getPreferredSize(), icon));
    }

    public abstract void initComponents();

    public abstract void paintComponent(Graphics g);
}
