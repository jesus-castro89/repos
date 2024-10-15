package rpg.gui;

import rpg.gui.buttons.BaseButton;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JButton button1;
    private JButton b2;
    private JButton b3;
    private JLabel exampleLabel;

    public MainWindow() {

        // Definimos el título de la ventana
        setTitle("RPG Game");
        // Definimos la operación por defecto al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Definimos el panel principal
        setContentPane(mainPanel);
        // Tomamos el tamaño de los componentes
        pack();
        // Centramos la ventana
        setLocationRelativeTo(null);
        // Hacemos visible la ventana
        setVisible(true);
        // Definimos que la ventana no se pueda redimensionar
        setResizable(false);
        initComponents();
    }

    private void initComponents() {

    }

    public static void main(String[] args) {
        new MainWindow();
    }

    /**
     * Esta función permite personalizar los componentes de la ventana.
     * Como por ejemplo usar clases propias que extiendan de JPanel u otros componentes.
     * <p>
     * **IMPORTANTE**: Si marcamos algún componente en el editor de diseño como
     * "Custom Create", deberemos que especificar como se creara en esta función.
     */
    private void createUIComponents() {
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();
        button1 = new BaseButton("Button 1");
        b2 = new BaseButton("Tiendas");
        b3 = new BaseButton("Inventario");
        exampleLabel = new JLabel() {

            @Override
            public void paint(Graphics g) {

                Graphics2D g2d = (Graphics2D) g;
                ImageIcon icon = new ImageIcon("image/player/portrait.png");
                g2d.drawImage(icon.getImage(), 0, 0, this);
                super.paint(g);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(117, 117);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
    }
}
