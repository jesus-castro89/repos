package rpg.gui;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.EnemyFactory;
import rpg.entities.enemies.goblins.GoblinGeneral;
import rpg.entities.enemies.goblins.RookieGoblin;
import rpg.enums.BarType;
import rpg.gui.buttons.*;
import rpg.gui.internalFrames.StatusFrame;
import rpg.gui.labels.*;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JButton blacksmithButton;
    private JButton shopButton;
    private JButton inventoryButton;
    private JLabel exampleLabel;
    private JButton atacarButton;
    private JButton habilidadesButton;
    private JButton huirButton;
    private JTextArea textDisplay;
    private JScrollPane textScroll;
    private JLabel lifeLabel;
    private JLabel magicLabel;
    private JLabel expLabel;
    private JLabel nameLabel;
    private JLabel goldLabel;
    private JButton exitButton;
    private JButton saveButton;
    private JLabel playerSprite;
    private JLabel enemySprite;
    private JLabel enemyLifeLabel;
    private JLabel enemyNameLabel;
    private JDesktopPane desktopPane;
    private JInternalFrame internalFrame;
    Player player;
    Enemy enemy;

    public MainWindow() {
        player = new Player("Miguel");
        initComponents();
        internalFrame = new StatusFrame();
        desktopPane.add(internalFrame, JLayeredPane.PALETTE_LAYER);
        blacksmithButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame.setVisible(true);
            }
        });
        appendText("¡Bienvenido a RPG Game!\n");
        appendText("¡Prepárate para la aventura!\n");
        while (player.isAlive() && enemy.isAlive()) {
            appendText(player.attack(enemy));
            if (enemy.isAlive())
                appendText(enemy.attack(player));
        }
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
        textDisplay.setFont(UIConstants.FONT.deriveFont(28f));
        textDisplay.setBorder(new EmptyBorder(10, 10, 10, 10));
        textDisplay.setForeground(Color.WHITE);
        textDisplay.setColumns(1);
        textDisplay.setEditable(false);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    public void appendText(String text) {

        textDisplay.append(text);
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }

    /**
     * Esta función permite personalizar los componentes de la ventana.
     * Como por ejemplo usar clases propias que extiendan de JPanel u otros componentes.
     * <p>
     * **IMPORTANTE**: Si marcamos algún componente en el editor de diseño como
     * "Custom Create", deberemos que especificar como se creara en esta función.
     */
    private void createUIComponents() {
        enemy = EnemyFactory.getEnemy();
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();
        blacksmithButton = new BlacksmithButton();
        shopButton = new ShopButton();
        inventoryButton = new InventoryButton();
        exitButton = new ExitButton();
        saveButton = new SaveButton();
        atacarButton = new AttackButton();
        habilidadesButton = new SkillPanelButton();
        huirButton = new FleeButton();
        exampleLabel = new PortraitLabel();
        lifeLabel = new BarLabel(100, 100, BarType.LIFE);
        magicLabel = new BarLabel(30, 100, BarType.MAGIC);
        expLabel = new BarLabel(0, 350, BarType.EXPERIENCE);
        goldLabel = new GoldLabel();
        nameLabel = new NameLabel("Miguel LVL. 1");
        playerSprite = new PlayerSpriteLabel();
        enemyNameLabel = new NameLabel(enemy.getName());
        enemyLifeLabel = new BarLabel(100, 100, BarType.LIFE);
        enemySprite = new EnemySpriteLabel(enemy);
        enemySprite.setBorder(new LineBorder(Color.RED, 2));
    }
}
