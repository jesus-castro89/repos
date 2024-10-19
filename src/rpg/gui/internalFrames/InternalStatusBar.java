package rpg.gui.internalFrames;

import rpg.gui.WindowConstants;
import rpg.gui.panels.CenterPanel;
import rpg.gui.panels.LeftCornerPanel;
import rpg.gui.panels.RightCornerPanel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InternalStatusBar extends JPanel {
    private JPanel leftCornerPanel;
    private JPanel rightCornerPanel;
    private JPanel centerCornerPanel;
    private JPanel mainPanel;
    private JButton button1;
    private JLabel internalTitle;

    public InternalStatusBar(String title, Dimension dimension,
                             JInternalFrame internalFrame) {
        add(mainPanel);
        internalTitle.setText(title);
        internalTitle.setFont(WindowConstants.FONT.deriveFont(Font.BOLD, 25f));
        setUI(new BasicPanelUI() {
            @Override
            protected void installDefaults(JPanel p) {
                p.setBounds(0, 0, dimension.width, 77);
                p.getInsets(new Insets(0, 0, 0, 0));
                p.setOpaque(false);
            }

            @Override
            public Dimension getPreferredSize(JComponent c) {
                return new Dimension(dimension.width, 77);
            }
        });
        updateWidth(dimension.width);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                internalFrame.setVisible(false);
            }
        });
    }

    public void updateWidth(int width) {
        mainPanel.setSize(width, 77);
        setSize(width, 77);
        ((CenterPanel) centerCornerPanel).setDimension(new Dimension(width - 100, 77));
    }

    private void createUIComponents() {
        leftCornerPanel = new LeftCornerPanel();
        rightCornerPanel = new RightCornerPanel();
        centerCornerPanel = new CenterPanel();
    }
}
