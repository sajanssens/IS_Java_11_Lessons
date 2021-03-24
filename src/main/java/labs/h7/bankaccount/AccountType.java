package labs.h7.bankaccount;

public enum AccountType {

    SAVINGS_ACCOUNT(1.03), // leuk gedaan
    REGULAR_ACCOUNT(1.01);

    private final double interestRate;

    AccountType(double interestRate){
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
