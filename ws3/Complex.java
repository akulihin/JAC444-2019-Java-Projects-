
public class Complex implements Cloneable {
	private double realPart;
	private double imaginaryPart;

	public Complex(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	public Complex(double realPart) {
		this.realPart = realPart;
		this.imaginaryPart = 0;
	}

	public Complex() {
		this.realPart = 0;
		this.imaginaryPart = 0;
	}

	// I hardly disagree with using "Cloneable" for this task, I see only one reason
	// to use it - for an array.
	// implementing clone method in THE RIGHT WAY is very complicated
	// so copy const. is my choise
	// btw, its not faster for this task at all
	public Complex(Complex obj) {
		this.realPart = obj.realPart;
		this.imaginaryPart = obj.imaginaryPart;
	}

	// but if you want me to show how to use clone - there we go
	// btw, Cloneable does not even have clone() method..
	public Object clone() throws CloneNotSupportedException {
		return super.clone();

	}

	public Complex getClone() {
		try {
			return (Complex) this.clone();

			// if it will give an error - I will call copy constructor
			// because Cloneable is creating an object bypassing the constructor, means it
			// can be a problem
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return new Complex(this);
		}

	}

	public void setVariables(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	public String toString(double compNum, double imaginNum) {
		if (imaginNum == 0) {
			String result = Double.toString(compNum);
			return result;
		} else {
			return compNum + " + " + imaginNum + "i";
		}
	}

	public double getRealPart() {
		return this.realPart;
	}

	public double getImaginaryPart() {
		return this.imaginaryPart;
	}

	public void add(Complex com2) {
		double realResult = this.getRealPart() + com2.getRealPart();
		double imaginResult = this.getImaginaryPart() + com2.getImaginaryPart();

		System.out.println("(" + this.toString(this.getRealPart(), this.getImaginaryPart()) + ") + ("
				+ com2.toString(com2.getRealPart(), com2.getImaginaryPart()) + ") = " + realResult + " + "
				+ imaginResult + "i");
	}

	public void substract(Complex com2) {
		double realResult = this.getRealPart() - com2.getRealPart();
		double imaginResult = this.getImaginaryPart() - com2.getImaginaryPart();

		System.out.println("(" + this.toString(this.getRealPart(), this.getImaginaryPart()) + ") - ("
				+ com2.toString(com2.getRealPart(), com2.getImaginaryPart()) + ") = " + realResult + " + "
				+ imaginResult + "i");
	}

	public void multiply(Complex com2) {
		double realResult = this.getRealPart() * com2.getRealPart() - this.getImaginaryPart() * com2.getImaginaryPart();
		double imaginResult = this.getImaginaryPart() * com2.getRealPart()
				+ this.getRealPart() * com2.getImaginaryPart();

		System.out.println("(" + this.toString(this.getRealPart(), this.getImaginaryPart()) + ") * ("
				+ com2.toString(com2.getRealPart(), com2.getImaginaryPart()) + ") = " + realResult + " + "
				+ imaginResult + "i");
	}

	public void divide(Complex com2) {
		double pow2Plus = Math.pow(com2.getRealPart(), 2) + Math.pow(com2.getImaginaryPart(), 2);
		double realResult = (this.getRealPart() * com2.getRealPart()
				+ this.getImaginaryPart() * com2.getImaginaryPart()) / pow2Plus;
		double imaginResult = (this.getImaginaryPart() * com2.getRealPart()
				- this.getRealPart() * com2.getImaginaryPart()) / pow2Plus;

		System.out.println("(" + this.toString(this.getRealPart(), this.getImaginaryPart()) + ") / ("
				+ com2.toString(com2.getRealPart(), com2.getImaginaryPart()) + ") = " + realResult + " + "
				+ imaginResult + "i");
	}

	public void abs() {
		double result = Math.sqrt(Math.pow(this.getRealPart(), 2) + Math.pow(this.getImaginaryPart(), 2));
		System.out.println("|(" + this.toString(this.getRealPart(), this.getImaginaryPart()) + ")| = " + result);
	}

}
