package labs.h7.bankaccount;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a Bank account
 */
public class Bank {

    private final String BANK_ABBREVIATION = "INGB";

    private BigDecimal totalBankBalance;
    private BigDecimal totalBankAccountsBalance;
    private Set<Account> allAccounts;
    private String bankName;

    public Bank(BigDecimal totalBankBalance, String bankName) {
        this.totalBankBalance = totalBankBalance;
        initTotalBankAccountsBalance();
        this.allAccounts = new HashSet<>();
        this.bankName = bankName;
    }

    public String getBankAbbreviation() {
        return BANK_ABBREVIATION;
    }

    public BigDecimal getTotalBankBalance() {
        return totalBankBalance;
    }

    public void setTotalBankBalance(BigDecimal totalBankBalance) {
        this.totalBankBalance = totalBankBalance;
    }

    public BigDecimal getTotalBankAccountsBalance() {
        return totalBankAccountsBalance;
    }

    public Set<Account> getAllAccounts() {
        return allAccounts;
    }

    public String getBankName() {
        return bankName;
    }

    public void addAccount(Account account){
        this.allAccounts.add(account);
    }

    private void initTotalBankAccountsBalance() {

        BigDecimal totalAccountsBalance = BigDecimal.ZERO;

        allAccounts
                .forEach(Account -> totalAccountsBalance.add(Account.getBalance()));

        double sum = allAccounts.stream()
                .map(Account::getBalance)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();

        this.totalBankAccountsBalance = totalAccountsBalance;
    }

    public void subtractTotalBankBalance(BigDecimal interestToGrant) {
        this.totalBankBalance.subtract(interestToGrant);
    }
}
