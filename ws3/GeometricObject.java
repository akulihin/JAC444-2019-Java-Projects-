public abstract class GeometricObject {
    private String color;
    private int numberOfSides;

    public GeometricObject() {
        this.color = "white";
        this.numberOfSides = 0;
    }

    /** Return color */
    public String getColor() {
        return color;
    }

    /** Set a new color */
    public void setColor(String color) {
        this.color = color;
    }

    /** Set number of sides */
    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    /** get NumberOfSides */
    public int getNumberOfSides() {
        return numberOfSides;
    }

    /** Abstract method getArea */
    public abstract double getArea();

    /** Abstract method getPerimeter */
    public abstract double getPerimeter();
}