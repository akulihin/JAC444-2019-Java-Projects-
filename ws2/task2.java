import java.awt.List;
import java.text.DecimalFormat;
import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        start();
    }

    public static boolean bad = false;

    public static class Location {
        public double row;
        public double column;
        public double maxValue;

        public Location(double row, double column, double maxValue) {
            this.row = row;
            this.column = column;
            this.maxValue = maxValue;
        }
    }

    public static void start() {
        DecimalFormat df = new DecimalFormat();
        df.setGroupingUsed(false);

        var input = new Scanner(System.in);
        var matrix = new double[0][0];

        do {
            System.out.print("Enter numbers of rows and columns in the array: ");

            var arraySize = input.nextLine();
            matrix = getMatrix(arraySize);

        } while (bad);

        System.out.println("Enter the array:");

        for (var i = 0; i < matrix.length; i++) {
            var array = input.nextLine();
            matrix[i] = getArray(array, matrix[0].length);
        }

        var largest = locateLargest(matrix);

        System.out.println("The location of the largest elemnt is " + df.format(largest.maxValue) + " at (row: "
                + df.format(largest.row) + ", col: " + df.format(largest.column) + ")");
        input.close();
    }

    public static Location locateLargest(double[][] matrix) {
        var largest = new Location(0, 0, 0);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                double value = matrix[row][col];
                if (value > largest.maxValue) {
                    largest.row = row + 1;
                    largest.column = col + 1;
                    largest.maxValue = value;
                }
            }
        }
        return largest;
    }

    public static double[][] getMatrix(String in) {
        var splited = in.split(" ");
        var index0 = 0;
        var index1 = 0;

        var check = 0;
        for (var i = 0; i < splited.length; i++) {
            if (isInt(splited[i]) && check == 0) {
                index0 = Integer.parseInt(splited[i]);
                check++;
            } else if (isInt(splited[i]) && check == 1) {
                index1 = Integer.parseInt(splited[i]);
                check++;
            }
        }
        if (check != 2 || index0 > 100 || index1 > 100) {
            index0 = 0;
            index1 = 0;
            System.out.println("wrong array size (100 is max), plese try again");
            bad = true;
        } else {
            bad = false;
        }
        return new double[index0][index1];
    }

    public static double[] getArray(String in, int maxSize) {
        var splited = in.split(" ");
        List list = new List();

        for (var i = 0; i < splited.length; i++) {
            if (isDouble(splited[i])) {
                list.add(splited[i]);
            }
        }

        var dou = new double[maxSize];

        for (var i = 0; i < list.getItemCount() && i < maxSize; i++) {
            dou[i] = Double.parseDouble(list.getItem(i));
        }

        return dou;
    }

    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}