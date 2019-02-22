import java.util.Scanner;

public class task3 {

    public static void main(String[] args) {
        var creditCardNumber = getCardNumber();
        var validated = validateCard(creditCardNumber);

        System.out.print(creditCardNumber);
        if (validated) {
            System.out.print(" is valid");
        } else {
            System.out.print(" is invalid");
        }
    }

    private static boolean validateCard(long cardNumber) {
        var prefix = getPrefix(cardNumber);
        var isGood = validatePrefix(prefix);

        if (!isGood)
            return isGood;

        var cardNumberReverse = getReverseArray(cardNumber);
        var doubled = getDoubleEverySecond(cardNumberReverse);
        var odd = getOdd(cardNumberReverse);
        var sum = doubled + odd;

        if (sum % 10 == 0)
            return true;
        else
            return false;
    }

    private static boolean validatePrefix(int prefix) {
        if (prefix == 4 || prefix == 5 || prefix == 37 || prefix == 6)
            return true;

        return false;
    }

    private static int getPrefix(long num) {
        var prefix = 0;

        var numArr = getIntArray(num);
        prefix = numArr[0];

        if (numArr[0] == 3 && numArr[1] == 7)
            prefix = 37;

        return prefix;
    }

    private static int[] getIntArray(long num) {
        var numberArr = Long.toString(num);
        int[] cardNumberArray = new int[numberArr.length()];

        for (var i = 0; i < numberArr.length(); i++) {
            cardNumberArray[i] = numberArr.charAt(i) - '0';
        }
        return cardNumberArray;
    }

    private static int getOdd(int[] cardNumberReverse) {
        var temp = 0;
        for (var i = 0; i < cardNumberReverse.length; i++) {
            var x = i + 1;
            if ((x % 2) != 0) {

                temp += cardNumberReverse[i];
            }
        }
        return temp;
    }

    private static int getDoubleEverySecond(int[] cardNumberReverse) {
        var temp = 0;

        for (var i = 1; i < cardNumberReverse.length; i += 2) {
            temp += validateSingleNumber(cardNumberReverse[i] * 2);
        }

        return temp;
    }

    private static int validateSingleNumber(int num) {

        if (num >= 10) {

            var cardNumberArray = getIntArray(num);

            return cardNumberArray[0] + cardNumberArray[1];
        }

        return num;
    }

    private static long getCardNumber() {
        var input = new Scanner(System.in);
        boolean good = false;
        long cardNumber = 0;
        do {
            System.out.println("Enter a credit card number:");
            var numberString = input.nextLine();

            if (numberString.length() > 0) {
                if (numberString.toLowerCase().contains("exit"))
                    System.exit(0);
            }

            if (numberString.length() >= 13 && numberString.length() <= 16) {
                numberString = numberString.replaceAll("\\s+", "");
                good = isLong(numberString);

                if (good) {
                    cardNumber = Long.parseLong(numberString);
                }
            } else {
                System.out.println("invalid input. Please enter 13-16 numbers. input EXIT to exit the app");
            }
        } while (!good);

        input.close();
        return cardNumber;
    }

    private static int[] getReverseArray(long cardNumber) {

        var cardNumberArray = getIntArray(cardNumber);

        for (int i = 0; i < cardNumberArray.length / 2; i++) {
            int temp = cardNumberArray[i];
            cardNumberArray[i] = cardNumberArray[cardNumberArray.length - i - 1];
            cardNumberArray[cardNumberArray.length - i - 1] = temp;
        }
        return cardNumberArray;
    }

    public static boolean isLong(String str) {
        try {
            Long.parseLong(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}