
import java.util.ArrayList;

public class ws3 {

    // global vars
    public static int callCount = 1;
    public static int howManySquareObjects = 5;
    private static double assetLimit;
    private static Bank[] banks;
    private static Helpers help = new Helpers(); // helper functions
    // end global vars

    public static void main(String[] args) {

        var result = true;
        var tryAgain = true;

        do {

            do {
                var choise = askForTaskChoise();
                result = getTask(choise);
                if (result) {
                    System.out.println("wrong choise");
                }

            } while (result);

            tryAgain = askToTryAnotherTask();
            result = tryAgain;

        } while (tryAgain);
    }

    public static boolean getTask(double taskNO) {
        switch ((int) taskNO) {
        case 1:
            return testTask1();

        case 2:
            return testTask2();

        case 3:
            return testTask3();

        default:
            return true;
        }
    }

    public static boolean askToTryAnotherTask() {
        var flag = true;
        var answer = false;
        do {

            System.out.print("Try anotehr task? (Y or N): ");
            var str = help.getNextLine();

            if (str.contains("y")) {
                answer = true;
                flag = false;
            } else {
                flag = false;
            }
        } while (flag);

        return answer;
    }

    public static double askForTaskChoise() {
        var mes = "Choose task (1, 2 or 3): ";
        System.out.print(mes);
        return help.getDouble(mes);
    }

    ////////////////// WS_1 //////////////////////
    ////////////////// WS_1 //////////////////////
    ////////////////// WS_1 //////////////////////
    ////////////////// WS_1 //////////////////////
    ////////////////// WS_1 //////////////////////
    ////////////////// WS_1 //////////////////////
    ////////////////// WS_1 //////////////////////
    ////////////////// WS_1 //////////////////////

    public static boolean testTask1() {

        // using Complex

        callCount = 1;
        var complexObject = new Complex();

        var com1 = getComplexNumbers(complexObject);
        var com2 = getComplexNumbers(complexObject);

        com1.add(com2);
        com1.substract(com2);
        com1.multiply(com2);
        com1.divide(com2);
        com1.abs();
        return false;
    }

    public static Complex getComplexNumbers(Complex complexObject) {
        double[] numbers = { 0, 0 };

        var flag = true;

        do {
            System.out.print(String.format("Enter the %s complex number : ", getCountWord(callCount)));

            var str = help.getNextLine().trim().replaceAll(" +", " ");

            if (str.length() < 1) {
                str = "0";
            }

            var splited = str.split(" ");

            if (splited.length <= 2) {

                for (var i = 0; i < splited.length; i++) {

                    if (help.isDouble(splited[i])) {
                        numbers[i] = Double.parseDouble(splited[i]);
                        flag = false;
                    } else {
                        System.out.println("wrong input, try again.");
                        flag = true;
                        break;
                    }
                }
            } else {
                System.out.println("enter 0 to 2 numbers");
            }

        } while (flag);

        callCount++;
        /////// Cloneable example:

        var objToReturn = complexObject.getClone();

        /////// Copy costr. example:

        // var objToReturn = new Complex(complexObject);

        objToReturn.setVariables(numbers[0], numbers[1]);

        return objToReturn;
    }

    public static String getCountWord(int number) {
        switch (number) {
        case 1:
            return "First";
        case 2:
            return "Second";
        case 3:
            return "Third";
        case 4:
            return "Fourth";
        case 5:
            return "Fifth";
        case 6:
            return "Sixth";
        case 7:
            return "Seventh";
        case 8:
            return "Eighth";
        case 9:
            return "Ninth";

        default:
            return "" + number;
        }
    }
    // end of ws1

    ////////////////// WS__2 //////////////////////
    ////////////////// WS__2 //////////////////////
    ////////////////// WS__2 //////////////////////
    ////////////////// WS__2 //////////////////////
    ////////////////// WS__2 //////////////////////
    ////////////////// WS__2 //////////////////////
    ////////////////// WS__2 //////////////////////
    ////////////////// WS__2 //////////////////////

    private static boolean testTask2() {
        BankManager();
        return false;
    }

    public static void BankManager() {
        var mes = "Number of banks: ";
        System.out.print(mes);
        var bankNum = (int) help.getDouble(mes);

        mes = "Minimum asset limit: ";
        System.out.print(mes);
        assetLimit = help.getDouble(mes);

        banks = new Bank[bankNum];

        for (int i = 0; i < bankNum; i++) {
            banks[i] = new Bank(banks);

            banks[i].setBankLoan(banks);
        }

        Result();
    }

    // this code looks like garbage, but it 5 am.... I guess I need use more
    // time....
    public static void updAllBanks_IsSafe() {

        var temp = banks;
        var unsafeBanksId = new ArrayList<Integer>();
        var knownBanksId = new ArrayList<Integer>();

        for (var i = 0; i < temp.length; i++) {
            knownBanksId.add(temp[i].bankID);
        }

        for (var i = 0; i < temp.length; i++) {
            for (var k = 0; k < temp[i].bankLoan.length; k++) {
                if (!knownBanksId.contains(temp[i].bankLoan[k].loanBankID)) {
                    temp[i].isSafe = false;
                    unsafeBanksId.add(temp[i].bankLoan[k].loanBankID);
                    unsafeBanksId.add(temp[i].bankID);

                }

            }
        }

        for (var i = 0; i < temp.length; i++) {

            for (var k = 0; k < temp[i].bankLoan.length; k++) {
                if (unsafeBanksId.contains(temp[i].bankLoan[k].loanBankID)) {
                    temp[i].bankLoan[k].loanAmount = 0;
                }
            }

            if (temp[i].isSafe && temp[i].getTotalAsset() < assetLimit) {
                temp[i].isSafe = false;
                banks[i].isSafe = false;
                unsafeBanksId.add(temp[i].bankID);
                i = 0;
            }
        }

    }

    public static void Result() {
        updAllBanks_IsSafe();

        System.out.println("Unsafe banks are:");

        for (int i = 0; i < banks.length; i++) {
            if (!banks[i].isSafe) {
                System.out.println("- Bank # " + banks[i].bankID);
            }
        }
    }

    // end of ws2

    ////////////////// WS___3 //////////////////////
    ////////////////// WS___3 //////////////////////
    ////////////////// WS___3 //////////////////////
    ////////////////// WS___3 //////////////////////
    ////////////////// WS___3 //////////////////////
    ////////////////// WS___3 //////////////////////
    ////////////////// WS___3 //////////////////////
    ////////////////// WS___3 //////////////////////

    private static boolean testTask3() {

        // using Square
        // using Geometric Object
        // using Colrable... why>

        Square[] arrayOfSquares = new Square[howManySquareObjects];
        var objCount = 1;

        // fake Unity Test:

        // array of the same, default, objects
        //
        // for (var i = 0; i < howManySquareObjects; i++) {
        // arrayOfSquares[i] = new Square();
        // }
        //

        // custom 5 objects
        //
        arrayOfSquares[0] = new Square();
        arrayOfSquares[1] = new Square(5, true);
        arrayOfSquares[2] = new Square(8, false);
        arrayOfSquares[3] = new Square(11, true, "purple");
        arrayOfSquares[4] = new Square(22, false, "red");
        //

        // custom 2 objects, even though we have array of 5
        //
        // arrayOfSquares[0] = new Square(33, true, "blue");
        // arrayOfSquares[4] = new Square(66, false, "red");
        //

        for (Square v : arrayOfSquares) {
            if (v == null)
                continue;

            System.out.println("Object number " + objCount++ + ":");
            System.out.println("Square area: " + v.getArea());

            if (v.isColorable) {

                System.out.println("Square color: " + v.getColor());
                System.out.print("How to color: ");
                v.howToColor();
            }

            System.out.println("");
        }
        return false;
    }
    // end of ws3
}
