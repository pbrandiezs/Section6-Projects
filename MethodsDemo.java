public class MethodsDemo {
    public static void main(String[] args) {
        printHello();
        printNumber(10);
        int result = giveMe10();
        System.out.println(result);

        result = addThese(3, 5);
        System.out.println(result);

        System.out.println("Square of double is " + squareOfDouble(3.145));
    }

    //void, parameterless method

    public static void printHello() {
        System.out.println("Hello there!");
    }

    //void, parameterized
    public static void printNumber(int a) {
        System.out.println("The number is " + a);
    }

    //value-returning, parameterless
    public static int giveMe10() {
        return 10;
    }

    //value-returning, parameterized
    public static int addThese(int num1, int num2) {
        return num1 + num2;
    }

    public static double squareOfDouble(double num1) {
        return num1 * num1;
    }
}
