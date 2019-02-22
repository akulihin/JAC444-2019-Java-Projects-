import java.util.*;

public class task1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var splited = new String[6];
        for (var j = 0; j < 2; j++) {
            var good = false;
            var abcdef = new ArrayList<Double>();

            while (!good) {
                System.out.print("Enter a, b, c, d, e, f: ");
                var str = input.nextLine();
                splited = str.split("\\s+");

                if (splited.length == 6) {
                    good = true;
                }
            }

            for (var i : splited) {
                try {
                    abcdef.add(Double.parseDouble(i));
                } catch (Exception e) {
                    System.out.println("Wrong input. Please enter 6 numbers separated by spaces!");
                    System.out.println("___________________________________");
                    main(args);
                    System.exit(0);
                }
            }

            // seems messy ._.
            var a = abcdef.get(0);
            var b = abcdef.get(1);
            var c = abcdef.get(2);
            var d = abcdef.get(3);
            var e = abcdef.get(4);
            var f = abcdef.get(5);

            if (a * d - b * c == 0) {
                System.out.println("The equation has no solution.");
                continue;
            }

            var x = (e * d - b * f) / (a * d - b * c);
            var y = (a * f - e * c) / (a * d - b * c);
            System.out.print("x is " + x);
            System.out.print(" and y is " + y);
            System.out.println("");
        }
        input.close();
    }
}