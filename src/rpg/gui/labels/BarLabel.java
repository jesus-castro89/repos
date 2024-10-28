package rpg.gui.labels;

import rpg.enums.BarType;
import rpg.gui.UIConstants;
import rpg.gui.ui.BarLabelUI;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class BarLabel extends JLabel {

    private ImageIcon icon;
    private int barValue;
    private int maxValue;
    private BarType type;

    public BarLabel(int value, int maxValue, BarType type) {

        this.barValue = value;
        this.maxValue = maxValue;
        this.type = type;
        initComponents();
    }

    public void initComponents() {

        setBarValue(barValue);
        setUI(new BarLabelUI(type));
    }

    public void setBarValue(int value) {

        this.barValue = value;
        setText(String.format("%d/%d", value, maxValue));
    }

    public int getBarValue() {
        return barValue;
    }

    public void setMaxValue(int value) {
        this.maxValue = value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public BarType getType() {
        return type;
    }
}
