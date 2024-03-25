package pl.dkulpa.creditcard;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal creditLimit;
    private BigDecimal balance;

    public void assignCredit(BigDecimal creditLimit) {

        
        
        // >100
        if (isCreditAlreadyAssigned()){
            throw new CreditCantBeReassigned();
        }
        if (isCreditBelowTreshold(creditLimit)){
            throw new CreditBelowThresholdException();
        }
        this.creditLimit = creditLimit;
        this.balance = creditLimit;
    }

    private boolean isCreditAlreadyAssigned() {
        return this.creditLimit != null;
    }

    private static boolean isCreditBelowTreshold(BigDecimal creditLimit) {
        return BigDecimal.valueOf(100).compareTo(creditLimit) > 0;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal money) {
        if (isNotEnoughMoney(money)) {
            throw new InsufficientFoundsException();
        }
        this.balance = this.balance.subtract(money);

    }

    private boolean isNotEnoughMoney(BigDecimal money) {
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO) < 0;
    }
}
