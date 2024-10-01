public class Exercise1 {
    private float area;
    private float perimeter;
    private float radius;

    public Exercise1(float radius) {
        this.radius = radius;
    }

    public float getArea() {
        area = (float) (Math.PI * (getRadius()*getRadius()));
        return area;
    }

    public float getPerimeter() {
        perimeter = (float) (2 * Math.PI * getRadius());
        return perimeter;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}