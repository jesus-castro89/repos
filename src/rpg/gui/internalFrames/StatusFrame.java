package rpg.gui.internalFrames;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;

public class StatusFrame extends JInternalFrame {

    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;

    public StatusFrame() {
        add(mainPanel);
        setPreferredSize(new Dimension(350, 200));
        setSize(getPreferredSize());
        mainPanel.setOpaque(false);
        setUI(new BasicInternalFrameUI(this){
            @Override
            public void setNorthPane(JComponent c) {
                super.setNorthPane(new JPanel());
            }
        });
    }
}
