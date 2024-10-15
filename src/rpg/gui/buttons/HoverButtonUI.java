package rpg.gui.buttons;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class HoverButtonUI extends BasicButtonUI {

    protected String text;
    protected int width;
    protected int height;
    protected ImageIcon[] parts;
    protected ImageIcon[] partsHover;

    public HoverButtonUI(String text) {
        this.text = text;
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(Math.max(width + 58, 84), 48);
    }

    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getPreferredSize(c);
    }

    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getPreferredSize(c);
    }

    @Override
    protected void installDefaults(AbstractButton b) {
        initParts();
        Font font = new Font("Arial", Font.BOLD, 18);
        b.setFont(font);
        b.setForeground(Color.BLACK);
        b.setDoubleBuffered(true);
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setIconTextGap(5);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.width = b.getFontMetrics(b.getFont()).stringWidth(text) + 24;
        this.height = 48;
    }

    public void initParts() {
        parts = new ImageIcon[3];
        partsHover = new ImageIcon[3];
        parts[0] = new ImageIcon("image/buttons/idle/user/leftSide.png");
        parts[1] = new ImageIcon("image/buttons/idle/user/centerSide.png");
        parts[2] = new ImageIcon("image/buttons/idle/user/rightSide.png");
        partsHover[0] = new ImageIcon("image/buttons/hover/user/leftSide.png");
        partsHover[1] = new ImageIcon("image/buttons/hover/user/centerSide.png");
        partsHover[2] = new ImageIcon("image/buttons/hover/user/rightSide.png");
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        Graphics2D g2d = (Graphics2D) g;
        AbstractButton button = (AbstractButton) c;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (button.getModel().isRollover()) {
            g2d.drawImage(partsHover[0].getImage(), 0, 0, null);
            g2d.translate(27, 0);
            g2d.drawImage(partsHover[1].getImage(), 0, 0, width, height, null);
            g2d.translate(width, 0);
            g2d.drawImage(partsHover[2].getImage(), 0, 0, null);
        } else {
            g2d.drawImage(parts[0].getImage(), 0, 0, null);
            g2d.translate(27, 0);
            g2d.drawImage(parts[1].getImage(), 0, 0, width, height, null);
            g2d.translate(width, 0);
            g2d.drawImage(parts[2].getImage(), 0, 0, null);
        }
        g2d.translate(-width - 27, 0);
        g2d.setColor(Color.WHITE);
        g2d.drawString(text, 0, 0);
        super.paint(g2d, c);
    }
}
