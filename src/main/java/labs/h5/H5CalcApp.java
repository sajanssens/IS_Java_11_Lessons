package labs.h5;

public class H5CalcApp {

    public static void main(String[] args) {

        //Greatest of two numbers
        System.out.println(H5Calc.greatest(5,10));

        //Highest length of two numbers
        System.out.println(H5Calc.greatest("Hello", "You"));

        //Greatest of an array of numbers
        System.out.println(H5Calc.greatest(1,2,3,4,5,89,56));

        //Factorial of a number
        System.out.println(H5Calc.factorial(6));
    }
}
