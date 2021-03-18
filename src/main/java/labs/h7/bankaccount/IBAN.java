package labs.h7.bankaccount;

import labs.h7.bankaccount.Exceptions.IllegalAccountNumberException;

import java.util.Random;

/**
 * This class represents a IBAN account number value. It contains a country abbreviation a bank abbreviation and
 * a 10 digit number
 */
public class IBAN {

    // Constants
    private final int LIMIT_ACCOUNT_NUMBER_LENGTH = 10;
    private final int UPPER_LIMIT_COUNTRY_NUMBER = 9;

    // Actual members
    private final String ORIGIN_COUNTRY = "NL";
    private final int COUNTRY_NUMBER;
    private final String BANK_ABBREVIATION;
    private final int NUMBER;

    /**
     * Constructor of this class. It only requires a Bank and a account number to generate an IBAN
     * @param bank      A Bank object is needed to access its abbreviation
     * @param number    A number is needed to append to the IBAN
     */
    public IBAN(Bank bank, int number) throws IllegalAccountNumberException {
        this.NUMBER = setNumberIfValid(number);
        this.COUNTRY_NUMBER = generateCountryNumber();
        this.BANK_ABBREVIATION = bank.getBankAbbreviation();
    }

    private int generateCountryNumber() {

        Random r = new Random();
        int firstDigit = r.nextInt(UPPER_LIMIT_COUNTRY_NUMBER);
        int secondDigit = r.nextInt(UPPER_LIMIT_COUNTRY_NUMBER);

        String concatDigitsString = "" + firstDigit + secondDigit;
        int concatDigits = Integer.parseInt(concatDigitsString);

        return concatDigits;
    }

    /**
     * Shows a user friendly representation of this object e.g. NL
     * @return
     */
    public String toString(){
        return ORIGIN_COUNTRY + COUNTRY_NUMBER + " " + BANK_ABBREVIATION + " " + NUMBER;
    }

    public int setNumberIfValid(int accountNumber) throws IllegalAccountNumberException {

        if(isNumberCorrectLength(accountNumber)){
            return accountNumber;
        } else throw new IllegalAccountNumberException("This is an invalid account number format");
    }

    private boolean isNumberCorrectLength(int accountNumber){
        return calcNumberLength(accountNumber) == LIMIT_ACCOUNT_NUMBER_LENGTH;
    }

    private int calcNumberLength(int number){

        int count = 0;
        int finalNumber = 0;
        int decimalDivisionNumber = 10;

        while (number != finalNumber){
            number /= decimalDivisionNumber;
            ++count;
        }

        return count;
    }
}
