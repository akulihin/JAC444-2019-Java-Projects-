import java.util.ArrayList;

public class ws4 {
    private static Helpers help = new Helpers(); // helper functions

    public static void main(String[] args) {
        var allCombinationsList = new ArrayList<String>(); // just to store all the values to see, if they are unique wiht allCombinationsList.contains()
        var message = "Please enter digits from 2 to 9: ";
        var phoneNumber = (long) help.getPhoneNumber(message);

        message = "" + phoneNumber;

        var totalLoops = (int) Math.pow(3, message.length());
        System.out.println("Total possible loops: " + totalLoops);

        for (var i = 0; i < totalLoops; i++) {
            var word = "";
            var count = i;
            var currentPhoneNumber = phoneNumber;

            for (int j = 0; j < message.length(); j++) {
                int ascii = getDecimalLetter((int) currentPhoneNumber % 10);
                ascii += (int) count % 3; // times

                // there is no Q in our Task,so i swap Q with S
                if (ascii == 81) {
                    ascii = 83;
                }

                word += (char) ascii;
                count = count / 3;
                currentPhoneNumber = currentPhoneNumber / 10;
            }
            allCombinationsList.add(word);
        }
        System.out
                .println("Total items in List: " + allCombinationsList.size() + " (breakpoint here to see all values)");

    }

    public static int getDecimalLetter(int number) {
        switch (number) {
        case 2:
            return 65; // A B C
        case 3:
            return 68; // D E F
        case 4:
            return 71; // G H I
        case 5:
            return 74; // J K L
        case 6:
            return 77; // M N O
        case 7:
            return 80; // P Q R S
        case 8:
            return 84; // T U V
        case 9:
            return 87; // W X Y Z // Z will not appear
        default:
            return 42; // * - MEANS ERROR ERROR
        }
    }
}
