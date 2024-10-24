package rpg.gui.ui;

import rpg.enums.BarType;
import rpg.gui.UIConstants;
import rpg.gui.labels.BarLabel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class BarLabelUI extends BasicLabelUI {

    private Dimension size;
    private ImageIcon icon;
    private BarType type;

    public BarLabelUI(Dimension size, ImageIcon icon) {

        this.type = type;
    }

    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false);
        c.setBorder(null);
        c.setForeground(Color.WHITE);
    }

    private int getBarValue(JLabel c) {
        return ((BarLabel) c).getBarValue();
    }

    private int getMaxBarValue(JLabel c) {
        return ((BarLabel) c).getMaxValue();
    }

    private int getBarWidth(JLabel c) {

        int value = getBarValue(c);
        int max = getMaxBarValue(c);
        if (value >= max) {
            value = max;
        } else if (value > 0 && value <= 25) {
            value = (int) (max * .18);
        }
        return (int) (value * 1.0 / max * 130);
    }

    @Override
    public void paint(Graphics g, JComponent c) {

        Graphics2D g2d = (Graphics2D) g;
        int textX = (getPreferredSize(c).width - c.getFontMetrics(c.getFont()).stringWidth(((JLabel) c).getText())) / 2;
        int textY = getPreferredSize(c).height - c.getFontMetrics(c.getFont()).getHeight() / 2;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(type.getContainer().getImage(), c.getWidth() - 150, 1, 150, 50, null);
        g2d.drawImage(type.getBar().getImage(), 32, 10, getBarWidth((JLabel) c), 14, null);
        g2d.drawImage(type.getIcon().getImage(), 0, 0, 51, 51, null);
        g2d.setColor(Color.BLACK);
        paintEnabledText((JLabel) c, g, ((JLabel) c).getText(), textX, textY);
    }

    @Override
    protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {

        textX = l.getIconTextGap() +
                ((UIConstants.BAR_LABEL.width - l.getFontMetrics(l.getFont()).stringWidth(s)) / 2);
        textY = (UIConstants.BAR_LABEL.height - l.getFontMetrics(l.getFont()).getHeight() / 2)
                + 5;
        super.paintEnabledText(l, g, s, textX, textY);
    }
}
