package pl.dkulpa.creditcard;

import org.junit.jupiter.api.Test;

import javax.naming.InsufficientResourcesException;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsAssignCredit(){
        //Arrange
        var card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assert BigDecimal.valueOf(1000).equals(card.getBalance());
        assertEquals(
                BigDecimal.valueOf(1000),
                card.getBalance()
        );
    }
    @Test
    void itAllowsAssignCredit2(){
        //Arrange
        var card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(2000));
        //Assert
        assert BigDecimal.valueOf(2000).equals(card.getBalance());
    }
    @Test
    void itDenyCreditBelowThresholdException(){
        var card = new CreditCard();

        try{
            card.assignCredit(BigDecimal.valueOf(50));
            assert false;
        }catch (CreditBelowThresholdException e){
            assert true;
        }

    }
    @Test
    void itDenyCreditBelowThresholdException2(){
        var card = new CreditCard();
        assertThrows(
                CreditBelowThresholdException.class,
        () -> card.assignCredit(BigDecimal.valueOf(50))
        );
    }
    @Test
    void itDenyCreditLimit(){
        var card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(100));

        assertThrows(
                CreditCantBeReassigned.class,
                () -> card.assignCredit(BigDecimal.valueOf(1500))
        );
    }
    @Test
    void itAllowsToWithdrawSomeMoney(){
        //Arrange
        var card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));
        //Act
        card.withdraw(BigDecimal.valueOf(500));
        //Assert
        assertEquals(
                BigDecimal.valueOf(500),
                card.getBalance()
        );
    }
    @Test
    void denyWhenNotEnoughMoney(){
        var card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(500));

        assertThrows(
                InsufficientFoundsException.class,
                ()-> card.withdraw(BigDecimal.valueOf(500))
        );
    }
}

