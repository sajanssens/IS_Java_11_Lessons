package labs.h7.bankaccount;

import labs.h7.bankaccount.Exceptions.BalanceException;

import java.math.BigDecimal;

public class Account {

    private IBAN accountNumber;
    private BigDecimal balance;
    private AccountType accountType;

    public Account(IBAN accountNumber, BigDecimal balance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    // BJ: geen onnodige getters/setters aanmaken
    public IBAN getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public BigDecimal calculateSingleYearInterest() {// BJ: methodes niet met witregel beginnen:

        BigDecimal interestRate = new BigDecimal(this.accountType.getInterestRate());
        return balance.multiply(interestRate);
    }

    public void receiveTransfer(BigDecimal amount) {
        this.balance.add(amount);
    }

    public void sendTransfer(BigDecimal amount) throws BalanceException {

        if (this.hasEnoughBalance(amount)) {
            this.balance.subtract(amount);
        } else throw new BalanceException(this.accountNumber.toString() + "does not have enough balance");

    }

    /**
     * BJ leuk om een keer gedaan te hebben, maar in dit geval voegt de javadoc weinig toe
     *
     * @param amount The minimal amount of currency this account should have
     * @return True if balance > amount
     * False if balance < amount
     */
    public boolean hasEnoughBalance(BigDecimal amount) {
        return balance.compareTo(amount) > 0;
    }

    public String toString() {

        return accountType.toString() + " " + accountNumber.toString() + " balance: " + balance;
    }
}
