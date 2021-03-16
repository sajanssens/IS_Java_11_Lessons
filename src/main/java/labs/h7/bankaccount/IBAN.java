package labs.h7.bankaccount;

/**
 * This class represents a IBAN account number value. It contains a country abbreviation a bank abbreviation and
 * a 10 digit number
 */
public class IBAN {

    private final int SET_NUMBER_LENGTH = 10;

    private final String originCountry = "NL";
    private final String bankAbbreviation;
    private int number;


    public IBAN(Bank bank, int number) {
        setNumber(number);
        this.bankAbbreviation = bank.getBankAbbreviation();
    }

    public String toString(){
        return originCountry + bankAbbreviation + " " + number;
    }

    public void setNumber(int accountNumber){
        if(isNumberCorrectLength(accountNumber)){
            this.number = accountNumber;
        }
    }

    public boolean isNumberCorrectLength(int accountNumber){
        return calcNumberLength(accountNumber) == SET_NUMBER_LENGTH;
    }

    public int calcNumberLength(int number){

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
