package rpg.utils;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileManager {
    private final String basePath = "files/";

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.writeFile("archivos.txt");
        fileManager.readFile("archivos.txt");
    }

    public FileManager(){
        UIManager.put("OptionPane.messageFont",
                new Font("Arial", Font.BOLD, 24));
    }

    public void writeFile(String fileName) {

        try {
            FileWriter writer = new FileWriter(basePath
                    + fileName);
            writer.write(JOptionPane.showInputDialog("Enter text"));
            writer.close();
            JOptionPane.showMessageDialog(null,
                    "File saved");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public void readFile(String fileName) {
        String line;
        String output = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(basePath + fileName));
            while ((line = reader.readLine()) != null) {
                output += line + "\n";
            }
            reader.close();
            JOptionPane.showMessageDialog(null, output);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
