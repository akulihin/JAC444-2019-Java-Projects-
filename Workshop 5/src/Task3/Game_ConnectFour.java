package Task3;

import help.*;

public class Game_ConnectFour {
	Helpers help = new Helpers();
	private String winner = "";
	private final int row = 7;
	private final int column = 7;
	private String rowMatrix[][] = new String[row][column];

	public Game_ConnectFour() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				rowMatrix[i][j] = "";
			}
		}
	};

	public void Start() {
		var count = 0;
		var colour = "";
		while (winner.length() <= 1) {
			display();

			var mess = "Drop a ";

			if (count % 2 == 0) {
				mess += "red";
				colour = "R";
			} else {
				mess += "yellow";
				colour = "Y";
			}
			mess += " disk at a column (1-7): ";
			int columnNum = help.getIntRange(mess, 1, 7);

			for (int i = 0; i < row; i++) {
				if (rowMatrix[row - i - 1][columnNum - 1] == "") {
					rowMatrix[row - i - 1][columnNum - 1] = colour;
					break;
				}
			}

			count++;
			Check();
		}

		display();
		System.out.println("The " + winner + " player won");
	}

	public void Check() {
		verticalCheck(rowMatrix);
		horizontalCheck(rowMatrix);
		crossRightCheck(rowMatrix);
		crossLeftCheck(rowMatrix);
	}

	public void verticalCheck(String rowMatrix[][]) {
		for (int i = 0; i < row; i++) {
			int yCount = 0;
			int rCount = 0;
			for (int j = 0; j < column; j++) {
				if (rowMatrix[i][j] == "Y") {
					if (rCount != 0) {
						rCount = 0;
					}
					yCount++;
				} else if (rowMatrix[i][j] == "R") {
					if (yCount != 0) {
						yCount = 0;
					}
					rCount++;
				}

				if (yCount == 4) {

					winner = "Yellow";
				} else if (rCount == 4) {

					winner = "Red";
				}
			}
		}
	}

	public void horizontalCheck(String rowMatrix[][]) {
		for (int i = 0; i < row; i++) {
			int yCount = 0;
			int rCount = 0;
			for (int j = 0; j < column; j++) {
				if (rowMatrix[j][i] == "Y") {
					if (rCount != 0) {
						rCount = 0;
					}
					yCount++;
				} else if (rowMatrix[j][i] == "R") {
					if (yCount != 0) {
						yCount = 0;
					}
					rCount++;
				}

				if (yCount == 4) {
					winner = "Yellow";
				} else if (rCount == 4) {
					winner = "Red";
				}
			}
		}
	}

	public void crossRightCheck(String rowMatrix[][]) {
		for (int i = 3; i < 10; i++) {
			int j;
			int k;
			int yCount = 0;
			int rCount = 0;

			if (i < 7) {
				k = 0;
				for (j = i; j > -1; j--) {
					if (rowMatrix[j][k] == "Y") {
						if (rCount != 0) {
							rCount = 0;
						}
						yCount++;
					} else if (rowMatrix[j][k] == "R") {
						if (yCount != 0) {
							yCount = 0;
						}
						rCount++;
					}

					if (yCount == 4) {

						winner = "Yellow";
					} else if (rCount == 4) {

						winner = "Red";
					}
					k++;
				}
			} else {
				j = 6;
				for (k = i - 6; k < 7; k++) {
					if (rowMatrix[j][k] == "Y") {
						if (rCount != 0) {
							rCount = 0;
						}
						yCount++;
					} else if (rowMatrix[j][k] == "R") {
						if (yCount != 0) {
							yCount = 0;
						}
						rCount++;
					}

					if (yCount == 4) {

						winner = "Yellow";
					} else if (rCount == 4) {

						winner = "Red";
					}
					j--;
				}
			}
		}
	}

	public void crossLeftCheck(String rowMatrix[][]) {
		for (int i = 3; i < 10; i++) {
			int j;
			int k;
			int yCount = 0;
			int rCount = 0;

			if (i < 7) {
				k = 6;
				for (j = i; j > -1; j--) {
					if (rowMatrix[j][k] == "Y") {
						if (rCount != 0) {
							rCount = 0;
						}
						yCount++;
					} else if (rowMatrix[j][k] == "R") {
						if (yCount != 0) {
							yCount = 0;
						}
						rCount++;
					}

					if (yCount == 4) {

						winner = "Yellow";
					} else if (rCount == 4) {

						winner = "Red";
					}
					k--;
				}
			} else {
				j = 6;
				for (k = i - 6; k < -1; k--) {
					if (rowMatrix[j][k] == "Y") {
						if (rCount != 0) {
							rCount = 0;
						}
						yCount++;
					} else if (rowMatrix[j][k] == "R") {
						if (yCount != 0) {
							yCount = 0;
						}
						rCount++;
					}

					if (yCount == 4) {

						winner = "Yellow";
					} else if (rCount == 4) {

						winner = "Red";
					}
					j--;
				}
			}
		}
	}

	public void display() {
		for (int i = 0; i < row; i++) {
			System.out.print("|");
			for (int j = 0; j < column; j++) {
				if (rowMatrix[i][j] == "") {
					System.out.print(" ");
				} else {
					System.out.print(rowMatrix[i][j]);
				}
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}

}
