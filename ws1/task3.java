import java.text.DecimalFormat;
import java.util.*;

public class task3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var df = new DecimalFormat("#.##");
        double principal = 0, balance = 0, numberOfYears = 0, interest = 0;

        try {
            System.out.print("Loan Amount: ");
            balance = input.nextDouble();

            System.out.print("Number of Years: ");
            numberOfYears = input.nextInt();

            System.out.print("Annual Interest Rate: ");
            interest = input.nextDouble();
        } catch (Exception e) {
            System.out.println("Wrong input. Please enter numbers.");
            System.out.println("___________________________________");
            main(args);
            System.exit(0);
        }

        var r = interest / 12 / 100;
        var P = balance;
        var n = numberOfYears * 12;

        var monthlyPayment = P * r / (1 - 1 / Math.pow(1 + r, n));

        System.out.println("");
        System.out.println("Monthly Payment: " + df.format(monthlyPayment));
        System.out.println("Total Payment: " + df.format(monthlyPayment * numberOfYears * 12));
        System.out.println("");
        System.out.println("Payment#\tInterest\tPrincipal\tBalance");

        for (var i = 1; i <= numberOfYears * 12; i++) {
            interest = r * balance;
            principal = monthlyPayment - interest;
            balance = balance - principal;
            System.out.println(
                    i + "\t\t" + df.format(interest) + "\t\t" + df.format(principal) + "\t\t" + df.format(balance));
        }

        input.close();
    }
}