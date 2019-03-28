
package help;

import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helpers {
    private Scanner input = new Scanner(System.in);

    public int getIntRange(String message, int min, int max) {
        System.out.print(message);
        do {
            var i = getNextLine();
           
                if (isInt(i) &&  Integer.parseInt(i) >= min &&  Integer.parseInt(i) <= max) {
                    return Integer.parseInt(i);
                }
            
            System.out.println("input is incorrect, try again:");
            System.out.print(message);
        } while (true);

    }

    public boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void closeInput() {
        // why would you use it????
        // it's unsafe for your app, let this object just disappear together with input
        input.close();
        System.out.println("input closed! Be safe!");
    }

    public String getNextLine() {
        var i = input.nextLine().trim().replaceAll(" ", "");
        return i;
    }

    public File CreateFile(String fileName) throws IOException {
        var file = new File(fileName);
        file.createNewFile();
        return file;
    }

    public void SaveFile(String fileName, String stringData) throws IOException {
        Files.write(Paths.get(fileName), stringData.getBytes());
    }

    public String ReadFile(String fileName) throws IOException {

        String line = null;
        var toReturn = "";
        var fileReader = new FileReader(fileName);
        var bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            toReturn += line;
        }
        bufferedReader.close();
      return toReturn;
    }

}