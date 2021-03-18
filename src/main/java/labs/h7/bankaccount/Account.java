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

    public IBAN getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public BigDecimal calculateSingleYearInterest(){

        BigDecimal interestRate = new BigDecimal(this.accountType.getInterestRate());
        return balance.multiply(interestRate);
    }

    public void receiveTransfer(BigDecimal amount){
        this.balance.add(amount);
    }

    public void sendTransfer(BigDecimal amount) throws BalanceException {

        if (this.hasEnoughBalance(amount)) {
            this.balance.subtract(amount);
        }
        else throw new BalanceException( this.accountNumber.toString() + "does not have enough balance");

    }

    /**
     *
     * @param amount    The minimal amount of currency this account should have
     * @return          True if balance > amount
     *                  False if balance < amount
     */
    public boolean hasEnoughBalance(BigDecimal amount){
        return balance.compareTo(amount) > 0;
    }

    public String toString(){

        return accountType.toString() + " " + accountNumber.toString() + " balance: " + balance;
    }
}
