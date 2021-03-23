package labs.h4.elevenProof;

import java.util.Scanner;

/**Assignment:      The "Eleven Proof" algorithm was used to check whether a given number could be a bank account
 *                  number (see also Wikipedia).
 *                  The algorithm works as follows:9 * 1st-digit + 8 * 2nd-digit + .. + 1 * 9th-digit = sum.
 *                  If sum can be divided by 11, then it is valid.
 *
 */
public class elevenProofApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int accountNumber;

        System.out.println("Please input a account number ");
        accountNumber = Integer.parseInt(sc.nextLine());

        System.out.println("This is a" + isValid(accountNumber) + "account number" );

        sc.close();
    }

    /**
     *
     *
     * @param accountNumber     The accountnumber passed
     * @return
     *          Throws an IllegalArgumentException if the given accountnumber has more than 9 digits or is not
     *          divisible by 11.
     */
    private static String isValid(int accountNumber){

        String isValid = " valid ";
        int maxDigitsAllowed = 9;
        //String isNotValid = "n invalid ";

        if ( countDigitsOfNum(accountNumber) > maxDigitsAllowed ){
            throw new IllegalArgumentException();
        }
        if ( sumOfDigits(accountNumber) % 11 == 0 ){
            return isValid;
        }
        else throw new IllegalArgumentException();
    }

    private static int countDigitsOfNum(int num){

        int count = 0;

        while(num != 0) {
            num/=10;
            ++count;
        }
        return count;
    }
    /**
     * Calculates the sum of the digits of a natural number
     * @param accountNumber     Number of which the sum of digits should be calculated
     * @return                  Sum of the digits of the passed number
     */
    private static int sumOfDigits(int accountNumber){

        int initSum = 0;
        int amountOfDigits = countDigitsOfNum(accountNumber);
        return sumOfDigitsRecursion(accountNumber, amountOfDigits, initSum);
    }
//TODO not done
    /**
     * Calculates the sum of the digits of a natural number with recursion
     * @param num               Number to be summed
     * @param multiplier        A number to be used for the multiplication step of the eleven proof
     * @param sum               Calculated sum to be further summed recursively
     * @return                  Sum of the digits of the passed number
     */
    private static int sumOfDigitsRecursion(int num, int multiplier, int sum){

        if (num == 0){
            return sum;
        }
        else {
            int lastDigit = num % 10;

            sum += lastDigit*multiplier;
        }
        return sumOfDigitsRecursion(num/10, --multiplier, sum);
    }


}
