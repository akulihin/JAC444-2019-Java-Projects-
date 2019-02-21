import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {

        var input = new Scanner(System.in);
        System.out.println("Task 2: ");

        for (var i = 0; i < 2; i++) {
            int year = 0, m = 0, q = 0, j, k;

            try {
                while (year <= 0) {
                    System.out.print("Enter year: (e.g., 2012): ");
                    year = input.nextInt();
                }

                while (m < 1 || m > 12) {
                    System.out.print("Enter month: 1-12: ");
                    m = input.nextInt();
                }

                while (q <= 0 || q > 31) {
                    System.out.print("Enter the day of the month: 1-31: ");
                    q = input.nextInt();
                }
            } catch (Exception e) {
                System.out.println("Wrong input. Please enter numbers.");
                System.out.println("___________________________________");
                main(args);
                System.exit(0);
            }

            if (m == 1) {
                m = 13;
                year -= 1;
            }

            if (m == 2) {
                m = 14;
                year -= 1;
            }

            j = year / 100;
            k = year % 100;

            var h = (q + 26 * (m + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;

            System.out.println("Day of the week is " + getDay(h));
            System.out.println(" ");
        }
        input.close();
    }

    public static String getDay(int number) {
        switch (number) {
        case 0:
            return "Saturday";
        case 1:
            return "Sunday";
        case 2:
            return "Monday";
        case 3:
            return "Tuesday";
        case 4:
            return "Wednesday";
        case 5:
            return "Thursday";
        case 6:
            return "Friday";
        default:
            return "error";
        }
    }
}