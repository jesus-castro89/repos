package rpg.gui.buttons;

import javax.swing.*;
import java.awt.*;

public class BaseButton extends JButton {

    public BaseButton(String text) {
        setText(text);
        setIcon(new ImageIcon("image/icons/shopIdle.png"));
        setRolloverIcon(new ImageIcon("image/icons/shopHover.png"));
        setUI(new HoverButtonUI(text));
    }
}
