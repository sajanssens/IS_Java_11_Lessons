package labs.h7.bankaccount;

import labs.h7.bankaccount.Exceptions.BalanceException;

import java.math.BigDecimal;

public class AccountManager { // Class 'AccountManager' is never used ?

    private Bank bank;

    public AccountManager(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return this.bank;
    }

    public void transferMoney(Account sender, Account recipient, BigDecimal amount) throws BalanceException {

        sender.sendTransfer(amount);
        recipient.receiveTransfer(amount);
    }

    public void grantInterest(Account account){

        BigDecimal interestToGrant = account.calculateSingleYearInterest();
        this.bank.subtractTotalBankBalance(interestToGrant);
        account.receiveTransfer(interestToGrant);
    }

    public void showAllInterestPerAccount(){
        //TODO
    }

    public void withdrawMoney(Account account, BigDecimal withDrawAmount) throws BalanceException {
        account.sendTransfer(withDrawAmount);
    }

    public void depositMoney(Account account, BigDecimal depositAmount) {
        account.receiveTransfer(depositAmount);
    }
}
