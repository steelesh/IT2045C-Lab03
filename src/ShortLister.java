import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister{

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        ArrayList<Object> shortWords = new ArrayList<>();
        File selectedFile;
        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                while (reader.ready()){
                    shortWords.add(reader.readLine());
                }
                reader.close();
                System.out.println("\nData File \"" + selectedFile.getName() + "\" Read!\n");
                System.out.println("Word List Contains: " + shortWords);
                System.out.print("\nShort Words: ");
                collectAll(shortWords);
                System.out.println("\n\n");
            }
            else if(chooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION){
                System.out.println("Exiting Program");
                System.exit(0);
            }
            else{
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void collectAll(ArrayList al){
        ShortWordFilter filter = new ShortWordFilter();
        ArrayList<Object> filteredList = new ArrayList<>();
        for (Object words : al){
            if (filter.accept(words)){
                filteredList.add(words);
            }
        }
        System.out.print(filteredList);
    }
}