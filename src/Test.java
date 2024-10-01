public class Test {
    public int num1 = 12;
    private int num2 = 2;

    //constructor should be public and should be the name of your class
    public Test(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;

    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum2() {
        return num2;
    }
}
