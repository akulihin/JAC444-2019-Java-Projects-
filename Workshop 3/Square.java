/**
 * Its a Square
 */

public class Square extends GeometricObject implements Colorable {

    //can be private if needed
    public double sideLenght;
    public boolean isColorable;

    public Square() {
        this.sideLenght = 1;
        this.isColorable = true;
        setNumberOfSides(4);
    }

    public Square(double sideLenght, boolean isColorable) {
        this.sideLenght = sideLenght;
        this.isColorable = isColorable;
        setNumberOfSides(4);
    }

    public Square(double sideLenght, boolean isColorable, String color) {
        this.sideLenght = sideLenght;
        this.isColorable = isColorable;
        setColor(color);
        setNumberOfSides(4);
    }

    @Override
    public void howToColor() {
        if (isColorable)
            System.out.println("Color all four sides");
        else
            System.out.println("its not colorable");
    }

    @Override
    public double getArea() {
        return sideLenght * sideLenght;
    }

    @Override
    public double getPerimeter() {
        return sideLenght * 4;
    }
}