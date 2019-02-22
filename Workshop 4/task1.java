import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class task1 {

    public static int wrongTimes = 0;
    private static Helpers help = new Helpers(); // helper functions

    public static void main(String[] args) {
        var input = new Scanner(System.in);

        var wordsString = "";
      //  String[] words = { "program", "write", "that" };

        try {
            wordsString =  help.ReadFile("words.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    var words = wordsString.split(" ");

        var random = new Random();
        var randomIndex = random.nextInt(words.length); // 0 to .length - 1

        var toBeGuessed = words[randomIndex].toLowerCase();
        var notGuessed = "";

        for (var i = 0; i < toBeGuessed.length(); i++) {
            notGuessed += "*";
        }
        
        System.out.println("type EXIT to finish the game");
        while (notGuessed.contains("*")) {
            System.out.print("(Guess) Enter a letter in word " + notGuessed + " > ");
            var letter = input.nextLine().toLowerCase();
            notGuessed = validateLetter(letter, toBeGuessed, notGuessed);
        }

        System.out.println("The word is " + toBeGuessed + ". You missed " + wrongTimes + " times");
        System.out.print("Do you want to guess another word?  Enter Y or N> ");

        var letter = input.nextLine().toLowerCase();
        if (letter.charAt(0) == 'y') {
            main(args);
            System.exit(0);
        }
        input.close();
    }

    private static String validateLetter(String letter, String toBeGuessed, String notGuessed) {

        var c = letter.charAt(0);

        if(letter.contains("exit")){
            System.exit(0);
        }

        if (notGuessed.contains("" + c)) {
            System.out.println(c + " is already in the word");
            return notGuessed;
        }

        if (!toBeGuessed.contains("" + c)) {
            System.out.println(c + " is NOT in the word");
            wrongTimes++;
            return notGuessed;
        }

        var temp = new StringBuilder(notGuessed);
        for (var i = 0; i < toBeGuessed.length(); i++) {

            if (toBeGuessed.charAt(i) == c) {
                temp.setCharAt(i, c);
            }
        }

        return temp.toString();
    }

}