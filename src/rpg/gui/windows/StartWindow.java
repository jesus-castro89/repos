package rpg.gui.windows;

import rpg.gui.UIConstants;
import rpg.gui.buttons.LoadFileButton;
import rpg.gui.buttons.NewFileButton;
import rpg.gui.labels.NameLabel;
import rpg.gui.panels.FilesPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class StartWindow extends JFrame {
    private JPanel mainPanel;
    private JButton newFile1;
    private JButton loadFile1;
    private JLabel titleLabel;
    private JLabel file1Name;
    private JLabel file2Name;
    private JLabel file3Name;
    private JLabel file4Name;
    private JLabel file5Name;
    private JButton newFile2;
    private JButton newFile3;
    private JButton newFile4;
    private JButton newFile5;
    private JButton loadFile2;
    private JButton loadFile3;
    private JButton loadFile4;
    private JButton loadFile5;

    public static void main(String[] args) {
        new StartWindow();
    }

    public StartWindow() {
        this.setContentPane(mainPanel);
        this.setSize(UIConstants.START_WINDOW_DIMENSION);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void createUIComponents() {
        mainPanel = new FilesPanel();
        titleLabel = new JLabel("Java RPG");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        for (int i = 1; i <= 5; i++) {

            switch (i) {
                case 1 -> {
                    file1Name = new NameLabel(isFileEmpty(i) ? "-- SIN GUARDAR --" : "Guardado");
                    newFile1 = new NewFileButton();
                    loadFile1 = new LoadFileButton();
                    if(!isFileEmpty(i)) {
                        newFile1.setVisible(false);
                    }else {
                        loadFile1.setVisible(false);
                    }
                }
                case 2 -> {
                    file2Name = new NameLabel(isFileEmpty(i) ? "-- SIN GUARDAR --" : "Guardado");
                    newFile2 = new NewFileButton();
                    loadFile2 = new LoadFileButton();
                    if(!isFileEmpty(i)) {
                        newFile2.setVisible(false);
                    }else {
                        loadFile2.setVisible(false);
                    }
                }
                case 3 -> {
                    file3Name = new NameLabel(isFileEmpty(i) ? "-- SIN GUARDAR --" : "Guardado");
                    newFile3 = new NewFileButton();
                    loadFile3 = new LoadFileButton();
                    if(!isFileEmpty(i)) {
                        newFile3.setVisible(false);
                    }else {
                        loadFile3.setVisible(false);
                    }
                }
                case 4 -> {
                    file4Name = new NameLabel(isFileEmpty(i) ? "-- SIN GUARDAR --" : "Guardado");
                    newFile4 = new NewFileButton();
                    loadFile4 = new LoadFileButton();
                    if(!isFileEmpty(i)) {
                        newFile4.setVisible(false);
                    }else {
                        loadFile4.setVisible(false);
                    }
                }
                case 5 -> {
                    file5Name = new NameLabel(isFileEmpty(i) ? "-- SIN GUARDAR --" : "Guardado");
                    newFile5 = new NewFileButton();
                    loadFile5 = new LoadFileButton();
                    if(!isFileEmpty(i)) {

                        newFile5.setVisible(false);
                    }else {
                        loadFile5.setVisible(false);
                    }
                }
            }
        }
    }

    private boolean isFileEmpty(int slot) {

        return !new File("files/file" + slot + ".dat").exists();
    }
}
