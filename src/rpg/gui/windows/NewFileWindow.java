package rpg.gui.windows;

import javax.swing.*;
import java.awt.*;

public class NewFileWindow extends JFrame{
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JPanel mainPanel;

    public NewFileWindow() {
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(800, 250));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new NewFileWindow();
    }
}
