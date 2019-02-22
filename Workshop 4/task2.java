import java.io.IOException;

public class task2 {
    private static Helpers help = new Helpers(); // helper functions

    public static void main(String[] args) {

        var flag = true;
        var fileText = "";
        int[] allLettersArray = new int[26];

        do {
            try {
                System.out.print("Enter Filename (use allWords.txt for best result): ");
                var fileName = help.getNextLine();
                fileText = help.ReadFile(fileName);
                flag = false;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("");
            }
        } while (flag);

        var allLetters = fileText.toLowerCase();

        for (var i = 0; i < allLetters.length(); i++) {
            char letter = allLetters.charAt(i);
            allLettersArray[letter - 97]++;

        }

        for (var i = 0; i < allLettersArray.length; i++) {
            if (allLettersArray[i] > 0) {
                var letter = (char) (i + 97);
                System.out.println("Number of " + Character.toUpperCase(letter) + "'s: " + allLettersArray[i]);
            }
        }
    }
}