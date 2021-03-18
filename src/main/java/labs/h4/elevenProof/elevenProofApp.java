package labs.h4.elevenProof;

import java.util.Scanner;

public class elevenProofApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int accountNumber;

        System.out.println("Please input a account number ");
        accountNumber = Integer.parseInt(sc.nextLine());

        System.out.println("This is a" + isValid(accountNumber) + "account number" );
    }

    private static String isValid(int accountNumber){

        String isValid = " valid ";
        //String isNotValid = "n invalid ";

        if ( sumOfDigits(accountNumber) % 11 == 0 ){
            return isValid;
        }
        else throw new IllegalArgumentException();
    }

    /**
     * Calculates the sum of the digits of a natural number
     * @param accountNumber     Number of which the sum of digits should be calculated
     * @return                  Sum of the digits of the passed number
     */
    private static int sumOfDigits(int accountNumber){

        int initSum = 0;
        return sumOfDigitsRecursion(accountNumber, initSum);
    }

    /**
     * Calculates the sum of the digits of a natural number with recursion
     * @param num               Number to be summed
     * @param sum               Calculated sum to be further summed recursively
     * @return                  Sum of the digits of the passed number
     */
    private static int sumOfDigitsRecursion(int num, int sum){

        if (num == 0){
            return sum;
        }
        else {
            sum += num % 10;
        }
        return sumOfDigitsRecursion(num/10, sum);
    }

}
