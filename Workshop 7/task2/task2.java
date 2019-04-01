
public class task2 {
    int size = 2000;
    double regularAddingSum = 0;
    double parallelAddingSum = 0;
    double parallelAddingSumt1 = 0;
    double parallelAddingSumt2 = 0;
    double matrix1[][] = new double[size][size];
    double matrix2[][] = new double[size][size];

    public task2() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix1[i][j] = Math.random();
                matrix2[i][j] = Math.random();
            }
        }
    }

    public void launch() throws InterruptedException {

        parallel();
        regular();
        
        var is = (int) parallelAddingSum == (int) regularAddingSum;

        var answer = is ? "yes" : "no";

        System.out.println("Parallel sum equals to regular? : " + answer);

        if (!is) {
            System.out.println("Parallel sum = " + parallelAddingSum);
            System.out.println("regular sum = " + regularAddingSum);
        }
    }

    public void parallel() throws InterruptedException {
        var start = System.nanoTime();

        int midpoint = Math.floorDiv(matrix1.length, 2);

        // first half
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < midpoint; ++i) {
                    if (matrix1[i].length == matrix2[i].length) {
                        for (int j = 0; j < matrix1[i].length; ++j) {
                            parallelAddingSumt1 += matrix1[i][j] + matrix2[i][j];
                        }
                    }
                }
            }
        };

        // second half
        Thread t2 = new Thread() {
            public void run() {
                for (int i = midpoint; i < matrix1.length; ++i) {
                    if (matrix1[i].length == matrix2[i].length) {
                        for (int j = 0; j < matrix1[i].length; ++j) {
                            parallelAddingSumt2 += matrix1[i][j] + matrix2[i][j];
                        }
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        parallelAddingSum = parallelAddingSumt2 + parallelAddingSumt1;

        var end = System.nanoTime();
        double duration = (end - start);

        System.out.println("Parallel adding time: " + duration / 1000000000 + "s");
    }

    public void regular() {
        var start = System.nanoTime();
        double sum = 0;

        for (int i = 0; i < size; i++) {
            for (int m = 0; m < size; m++) {
                sum += matrix1[i][m] + matrix2[i][m];
            }
        }

        regularAddingSum = sum;

        var end = System.nanoTime();
        double duration = end - start;

        System.out.println("regular adding time: " + duration / 1000000000 + "s");
    }

    public static void main(String[] args) throws InterruptedException {
        var task2 = new task2();
        task2.launch();
    }
}