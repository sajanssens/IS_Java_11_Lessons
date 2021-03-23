package labs.h6;

import java.util.Arrays;

/**
 * Calculator class for the assignments of the H6 lab
 */
public class H6Calc {

    /**
     *Assignment 6.3 :  Create a method to increase the capacity of a long[] to twice its size by copying all the
     *                  elements and creating new elements, with default values for the newly created elements.
     *                  So, [1,2,3,4] should become [1,2,3,4,0,0,0,0].
     *
     * @param longArr
     * @return
     */
    public static long[] longList(long[] longArr){
        return Arrays.copyOf(longArr, longArr.length*2);
    }

    /**
     * Assignment 6.4:  Create a method to multiply each element of a long[] by a given multiplier: void multiply(long[]
     *                  input, int multiplier).
     *
     * @param input
     * @param multiplier
     */
    public static void multiply(long[] input, int multiplier){
        for ( int i = 0; i < input.length; i++){
            input[i] = input[i] * multiplier;
        }
    }

    /**
     * Assignment 6.5:  Change your previously (in H5) created method long run(int n) to long[] run(int n). This
     *                  method should not print the Fibonacci sequence itself, but instead it should return the Fibonacci
     *                  sequence as a long[] for n<94. Call this method and then iterate through the result to print the
     *                  sequence.
     *
     * @param n         The number of fibonacci terms to be calculated
     * @return          a long[] filled with the fibbonacci terms up to n
     * @throws          IllegalArgumentException if n>=94
     *
     */
    public static long[] run(int n ){

        if (n >= 94){
            throw new IllegalArgumentException();
        }

        long[] fibArr = new long[n-1];

        for ( int i = 0; i <fibArr.length; i++){
            fibArr[i] = fibonacci(i);
        }
        return fibArr;
    }

    /**
     * This method recursively calculates the a fibonacci term.
     * @param num       The fibonacci term to be calculated
     * @return          a fibonacci term
     */
    public static long fibonacci(long num){
        return (num <= 1) ? num : fibonacci(num-1) + fibonacci(num-2);
    }

}
