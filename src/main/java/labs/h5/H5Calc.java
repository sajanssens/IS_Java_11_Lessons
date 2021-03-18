package labs.h5;

/**
 * This class contains a few calculation methods some of which are overloaded.
 */
public class H5Calc {

    /**
     *
     * @param a         The first number to compare
     * @param b         The second number to compare
     * @return          An integer value representing the greatest of the two parameters
     */
    public static int greatest(int a, int b){
        return (a > b) ? a : b;
    }

    /**
     *
     * @param a         The first string to compare
     * @param b         The second string to compare
     * @return          A string value representing which of the two parameter strings has the longest length
     *                  e.g. ("Hello", "You") returns "Hello"
     */
    public static String greatest(String a, String b){
        return a.length() > b.length() ? a : b;
    }

    /**
     *
     * @param values    A integer parameter list containing the values to be compared
     * @return          The greatest value of the passed parameters e.g. parameters: 1,2,3,4. returns 4.
     */
    public static int greatest(int... values){

        int greatestNum  = 0;

        for ( int a : values){
            greatestNum = ( a > greatestNum ) ? a : greatestNum;
        }

        return greatestNum;
    }

    /**
     *
     * @param num       The number of which the factorial should be calculated
     * @return          The factorial of the passed integer.
     */
    public static int factorial(int num){
        return (num <= 1) ? 1 : num*factorial(num-1);
    }

}
