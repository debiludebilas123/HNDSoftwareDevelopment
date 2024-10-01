public class Exercise3 {
    private double num1;
    private double num2;

    public Exercise3(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double ansPlus() {
        return num1 + num2;
    }

    public double ansMin() {
        return num1 - num2;
    }

    public double ansMultiplication() {
        return num1 * num2;
    }

    public double absDivision() {
        return num1 / num2;
    }
}
