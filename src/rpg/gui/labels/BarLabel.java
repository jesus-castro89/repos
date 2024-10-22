package rpg.gui.labels;

import rpg.gui.UIConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class BarLabel extends JLabel{

    private ImageIcon icon;
    private int barValue;
    private int maxValue;

    public BarLabel(String text) {
        setText(text);
        initComponents();
    }

    public void initComponents() {

        ImageCache.addImage("bar",
                "player/lifeBar.png");
        icon = ImageCache.getImageIcon("bar");
        setPreferredSize(
                new Dimension(icon.getIconWidth(),
                        icon.getIconHeight()));
        setIcon(icon);
        setVerticalAlignment(JLabel.BOTTOM);
        setVerticalTextPosition(JLabel.BOTTOM);
        setHorizontalAlignment(JLabel.RIGHT);
        setHorizontalTextPosition(JLabel.CENTER);
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(icon.getImage(), 0, 0,
                getPreferredSize().width,
                getPreferredSize().height, this);
        g2d.setFont(UIConstants.FONT.deriveFont(Font.BOLD, 16));
        g2d.setColor(Color.WHITE);
        g2d.drawString(getText(), 10, 10);
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
}
