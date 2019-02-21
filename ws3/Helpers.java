
/**
 * Helpers
 */
import java.util.Scanner;

public class Helpers {
    private Scanner input = new Scanner(System.in);

    public double getDouble(String message) {
        do {
            var i = input.nextLine().trim().replaceAll(" ", "");
            if (isDouble(i) && Double.parseDouble(i) >= 0) {
                return Double.parseDouble(i);
            }
            System.out.println("input is incorrect, try again:");
            System.out.print(message);
        } while (true);

    }

    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
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

}