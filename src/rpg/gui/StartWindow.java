package rpg.gui;

import javax.swing.*;

public class StartWindow extends JFrame {

    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;

    public static void main(String[] args) {
        new StartWindow();
    }

    public StartWindow() {
        // Definimos el título de la ventana
        super("RPG");
        // Definimos el tamaño de la ventana
        setSize(800, 600);
        // Agregamos la funcionalidad de cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Definimos la ventana en el centro de la pantalla
        setLocationRelativeTo(null);
        // Forzamos que la ventana no se pueda redimensionar
        setResizable(false);
        // Agregar un panel a la ventana
        add(mainPanel);
        // Hacer visible la ventana
        setVisible(true);
    }
}
