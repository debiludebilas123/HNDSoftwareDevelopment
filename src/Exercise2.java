public class Exercise2 {
    private double width;
    private double length;

    public Exercise2(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Exercise2(double length) {
        this.length = length;
    }

    public double getRectangleDiameter() {
        return Math.sqrt(((width * width) + (length * length)));
    }

    public double getRectangleArea() {
        return width * length;
    }

    public double getSquareDiameter() {
        return Math.sqrt(2) * length;
    }

    public double getSquareArea() {
        return length * 4;
    }

}
