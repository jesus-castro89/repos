package rpg.gui;

import rpg.gui.buttons.*;
import rpg.gui.internalFrames.StatusFrame;
import rpg.gui.labels.BarLabel;
import rpg.gui.labels.PortraitLabel;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JButton button1;
    private JButton b2;
    private JButton b3;
    private JLabel exampleLabel;
    private JButton atacarButton;
    private JButton habilidadesButton;
    private JButton huirButton;
    private JTextArea textDisplay;
    private JScrollPane textScroll;
    private JLabel label1;
    private JDesktopPane desktopPane;
    private JInternalFrame internalFrame;

    public MainWindow() {
        initComponents();
        internalFrame = new StatusFrame();
        desktopPane.add(internalFrame, JLayeredPane.PALETTE_LAYER);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame.setVisible(true);
            }
        });
    }

    private void initComponents() {
        // Creamos un DesktopPane para poder agregar los componentes
        desktopPane = new JDesktopPane();
        // Hacemos que el tamaño del DesktopPane sea igual al
        // tamaño del panel principal
        desktopPane.setPreferredSize(mainPanel != null ?
                mainPanel.getPreferredSize() : null);
        // Definimos los Bounds del panel principal
        mainPanel.setBounds(0, 0, mainPanel.getPreferredSize().width,
                mainPanel.getPreferredSize().height);
        // Agregamos el panel principal al DesktopPane
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
        // Agregamos el panel principal a la ventana
        setContentPane(desktopPane);
        // Definimos el título de la ventana
        setTitle("RPG Game");
        // Definimos la operación por defecto al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Tomamos el tamaño de los componentes
        pack();
        // Centramos la ventana
        setLocationRelativeTo(null);
        // Hacemos visible la ventana
        setVisible(true);
        // Definimos que la ventana no se pueda redimensionar
        setResizable(false);
        textScroll.getViewport().setOpaque(false);
        textScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textDisplay.setFont(UIConstants.FONT.deriveFont(22f));
        textDisplay.setBorder(new EmptyBorder(10, 10, 10, 10));
        textDisplay.setForeground(Color.WHITE);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
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
        atacarButton = new AttackButton();
        habilidadesButton = new SkillPanelButton();
        huirButton = new FleeButton();
        exampleLabel = new PortraitLabel();
        label1=new BarLabel("100/100");
    }
}
