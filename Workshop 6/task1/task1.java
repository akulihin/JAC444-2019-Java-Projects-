
public class task1 {
	private static Helpers help = new Helpers(); // helper functions

	public static void main(String[] args) {
	
		var msg = "Enter the number of balls to drop: ";
		var balls = help.getInt(msg);
		msg = "Enter the number of slots in the bean machine:  ";
		var slots = help.getInt(msg);

		int[] slotsArr = new int[slots];
		double[] ballArr = new double[balls];

		for (int i = 0; i < balls; i++) {
			ballArr[i] = ((slotsArr.length) / 2);
		}

		System.out.println("");
		for (int i = 0; i < balls; i++) {
			{
				for (int m = 0; m < slots - 1; m++) {

					if (help.rand.nextBoolean()) {
						ballArr[i] -= 0.5;
						System.out.print("L");
					} else {
						ballArr[i] += 0.5;
						System.out.print("R");
					}
				}
				System.out.println("");
			}
		}

		for (int i = 0; i < balls; i++) {
			slotsArr[(int) ballArr[i]]++;
		}

		int size = help.max(slotsArr);

		char[][] output = new char[slotsArr.length][size];

		for (int i = 0; i < slotsArr.length; i++) {
			for (int m = 0; m < size; m++) {
				if (slotsArr[i] != 0) {
					if (m < slotsArr[i]) {
						output[i][m] = '0';
					} else {
						output[i][m] = ' ';
					}
				} else {
					output[i][m] = ' ';
				}
			}
		}

		System.out.println("");

		for (int i = output[0].length - 1; i >= 0; i--) {
			for (int m = 0; m < output.length; m++) {
				System.out.print(output[m][i]);
			}
			System.out.println("");
		}
	}
}