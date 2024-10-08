package rpg;

import java.io.*;

public class ExampleFile {

    public static void main(String[] args) {

        String line;
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("files/example.txt"));
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("files/another.txt"));
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
