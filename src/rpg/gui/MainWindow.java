package rpg.gui;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.EnemyFactory;
import rpg.enums.BarType;
import rpg.enums.Stats;
import rpg.gui.buttons.*;
import rpg.gui.internalFrames.StatusFrame;
import rpg.gui.labels.*;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MessagePanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
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
    private JPanel messagePanel;
    private JPanel enemyPanel;
    private JDesktopPane desktopPane;
    private final JInternalFrame internalFrame;
    Player player;
    Enemy enemy;

    public static void main(String[] args) {
        new MainWindow();
    }

    public MainWindow() {

        initComponents();
        player = new Player("Miguel");
        ((BarLabel) lifeLabel).updateBar(player.getStats().get(Stats.HP), player.getStats().get(Stats.MAX_HP));
        ((BarLabel) magicLabel).updateBar(player.getStats().get(Stats.MP), player.getStats().get(Stats.MAX_MP));
        ((BarLabel) expLabel).updateBar(player.getStats().get(Stats.EXPERIENCE), player.getStats().get(Stats.NEEDED_EXPERIENCE));
        internalFrame = new StatusFrame();
        desktopPane.add(internalFrame, JLayeredPane.PALETTE_LAYER);
        appendText("¡Bienvenido a RPG Game!\n");
        appendText("¡Prepárate para la aventura!\n");
        appendText("Aparece un nuevo enemigo: " + enemy.getName() + "\n");
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
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Tomamos el tamaño de los componentes
        pack();
        // Centramos la ventana
        setLocationRelativeTo(null);
        // Hacemos visible la ventana
        setVisible(true);
        // Definimos que la ventana no se pueda redimensionar
        setResizable(false);
        // Definimos la forma de trabajo del ScrollPane
        // Hacemos que el ScrollPane no tenga bordes y sea transparente
        textScroll.getViewport().setOpaque(false);
        textScroll.setBorder(null);
        // Hacemos que el ScrollPane tenga solo la barra vertical
        textScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Definimos el color de fondo del display en Blanco y su fuente en 28px
        textDisplay.setFont(UIConstants.FONT.deriveFont(28f));
        textDisplay.setForeground(Color.WHITE);
        // Configuramos el scrool del textDisplay
        textDisplay.setColumns(1);
        textDisplay.setEditable(false);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
    }

    /**
     * Esta función permite añadir texto al textDisplay.
     * <p>
     * **IMPORTANTE**: Esta función se llama desde otras clases.
     */
    public void appendText(String text) {

        // Añadimos el texto al textDisplay
        textDisplay.append(text);
        // Hacemos que el textDisplay se posicione en la última línea
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }

    /**
     * Esta función permite intentar huir de un combate.
     * <p>
     * **IMPORTANTE**: Esta función se llama desde la clase FleeButton.
     */
    public void tryToFlee() {

        // Si el jugador logra huir
        if (player.tryToFlee()) {
            // Añadimos un mensaje al textDisplay de que se logró huir
            appendText("Has huido con éxito.\n");
            // Creamos un nuevo enemigo
            createEnemy();
        } else {
            // Añadimos un mensaje al textDisplay de que no se pudo huir
            appendText("No has podido huir.\n");
            // El enemigo ataca al jugador
            appendText(enemy.attack(player));
        }
        // Actualizamos las barras status del jugador y del enemigo
        updateBars();
    }

    /**
     * Esta función permite verificar el estado del juego y actualizar las barras de estado.
     * <p>
     * **IMPORTANTE**: Esta función se llama desde la clase AttackButton.
     */
    public void checkGameStatus() {

        if (!player.isAlive()) {

            appendText("Has muerto.\n");
            appendText("GAME OVER\n");
        } else if (!enemy.isAlive()) {

            appendText("Has derrotado a " + enemy.getName() + "\n");
            appendText("Has ganado " + enemy.getStats().get(Stats.EXPERIENCE)
                    + " puntos de experiencia.\n");
            player.getStats().put(Stats.EXPERIENCE,
                    player.getStats().get(Stats.EXPERIENCE)
                            + enemy.getStats().get(Stats.EXPERIENCE));
            player.getStats().put(Stats.GOLD, player.getStats().get(Stats.GOLD)
                    + enemy.getStats().get(Stats.GOLD));
            if (player.getStats().get(Stats.EXPERIENCE) >=
                    player.getStats().get(Stats.NEEDED_EXPERIENCE)) {

                updatePlayer();
            }
            createEnemy();
        }
        updateBars();
    }

    private void createEnemy() {

        enemy = EnemyFactory.getEnemy();
        if (enemy != null) {

            enemyNameLabel.setText(enemy.getName());
            appendText("Aparece un nuevo enemigo: " + enemy.getName() + "\n");
            ((EnemySpriteLabel) enemySprite).setEnemy(enemy);
            ((NameLabel) enemyNameLabel).updateLabel(enemy.getName());
            ((BarLabel) enemyLifeLabel).updateBar(enemy.getStats().get(Stats.HP),
                    enemy.getStats().get(Stats.MAX_HP));
        }
    }

    private void updateBars() {

        ((BarLabel) lifeLabel).setBarValue(player.getStats().get(Stats.HP));
        ((BarLabel) expLabel).setBarValue(player.getStats().get(Stats.EXPERIENCE));
        ((BarLabel) enemyLifeLabel).setBarValue(enemy.getStats().get(Stats.HP));
    }

    private void updatePlayer() {

        player.levelUp();
        appendText("Has subido de nivel.\n");
        ((BarLabel) lifeLabel).updateBar(player.getStats().get(Stats.HP),
                player.getStats().get(Stats.MAX_HP));
        ((BarLabel) magicLabel).updateBar(player.getStats().get(Stats.MP),
                player.getStats().get(Stats.MAX_MP));
        ((BarLabel) expLabel).updateBar(player.getStats().get(Stats.EXPERIENCE),
                player.getStats().get(Stats.NEEDED_EXPERIENCE));
        ((NameLabel) nameLabel).updateLabel(player.getName() + " LVL. " +
                player.getStats().get(Stats.LEVEL));
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
        messagePanel = new MessagePanel();
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();
        blacksmithButton = new BlacksmithButton();
        shopButton = new ShopButton();
        inventoryButton = new InventoryButton();
        exitButton = new ExitButton();
        saveButton = new SaveButton();
        atacarButton = new AttackButton(this);
        habilidadesButton = new SkillPanelButton();
        huirButton = new FleeButton(this);
        exampleLabel = new PortraitLabel();
        lifeLabel = new BarLabel(0, 0, BarType.LIFE);
        magicLabel = new BarLabel(30, 0, BarType.MAGIC);
        expLabel = new BarLabel(0, 0, BarType.EXPERIENCE);
        goldLabel = new GoldLabel();
        nameLabel = new NameLabel("Miguel LVL. 1");
        playerSprite = new PlayerSpriteLabel();
        enemyNameLabel = new NameLabel(enemy.getName());
        enemyLifeLabel = new BarLabel(enemy.getStats().get(Stats.HP),
                enemy.getStats().get(Stats.MAX_HP), BarType.LIFE);
        enemySprite = new EnemySpriteLabel(enemy);
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
