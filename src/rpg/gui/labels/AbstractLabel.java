package rpg.gui.labels;

import rpg.gui.ui.LabelUI;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractLabel extends JLabel {

    protected ImageIcon icon;

    public AbstractLabel() {
        initComponents();
        setUI(new LabelUI(getPreferredSize(), icon));
    }

    public abstract void initComponents();

    public abstract void paintComponent(Graphics g);
}
