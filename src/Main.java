public class Main {
    public static void main(String[] args) {
        Test t1 = new Test(15, 5);

        System.out.println(t1.num1);
        t1.num1 = 14;
        System.out.println("The 1st number is: " + t1.num1);
        System.out.println("The 2nd number is: " + t1.getNum2());
        t1.setNum2(78);
        System.out.println(t1.getNum2());
        System.out.println("----------");
        shapesExercise();
    }

    public static void studentThingamabob() {
        Student s1 = new Student("sudas", "makaka");
        System.out.println(s1.getCollege());
        System.out.println(s1.getName());
    }

    public static void Exercise1Exercise() {
        Exercise1 c1 = new Exercise1(1);
        Exercise1 c2 = new Exercise1(25);
        Exercise1 c3 = new Exercise1(125);
        System.out.println(c1.getArea());
        System.out.println(c2.getArea());
        System.out.println(c3.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c2.getPerimeter());
        System.out.println(c3.getPerimeter());
    }

    public static void shapesExercise() {
        Exercise2 rectangle = new Exercise2(10, 15);
        System.out.println(rectangle.getRectangleDiameter());
        System.out.println(rectangle.getRectangleArea());
        Exercise2 square = new Exercise2(10);
        System.out.println(square.getSquareDiameter());
        System.out.println(square.getSquareArea());
    }
}
