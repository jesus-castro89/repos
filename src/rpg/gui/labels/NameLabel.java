package rpg.gui.labels;

import rpg.gui.UIConstants;
import rpg.gui.ui.NameLabelUI;

import javax.swing.*;
import java.awt.*;

public class NameLabel extends JLabel {

    public NameLabel(String name) {
        super();
        setText(name);
        setFont(UIConstants.LABEL_FONT);
        setForeground(Color.BLACK);
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalTextPosition(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
        FontMetrics metrics = getFontMetrics(getFont());
        int textWidth = metrics.stringWidth(getText());
        setPreferredSize(new Dimension(textWidth + 44, 51));
        setUI(new NameLabelUI());
    }
}
