package test.java;

import main.java.checkoutKata.Money;
import main.java.checkoutKata.Quantity;
import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {
    private Money moneyOne;
    private Money moneyTwo;
    private Money actualAmount;
    private Money expectedAmount;


    @Test
    public void shouldReturnTrueWhenTwoMoneyObjectAreEqual() {
        moneyOne = new Money(1);
        moneyTwo = new Money(1);

        Assert.assertTrue(moneyOne.equals(moneyTwo));
    }

    @Test
    public void shouldReturnFalseWhenTwoMoneyObjectAreNotEqual() {
        moneyOne = new Money(1);
        moneyTwo = new Money(2);

        Assert.assertFalse(moneyOne.equals(moneyTwo));
    }

    @Test
    public void shouldReturnCorrectValueWhenAddingMoney() {
        moneyOne = new Money(1);
        moneyTwo = new Money(2);

        actualAmount = moneyOne.add(moneyTwo);
        expectedAmount = new Money(3);

        Assert.assertEquals(actualAmount, expectedAmount);
    }

    @Test
    public void shouldReturnIntValueForMoney() {
        moneyOne = new Money(1);
        int actualAmount = moneyOne.getAsInt();

        Assert.assertEquals(actualAmount, 1);
    }

    @Test
    public void shouldReturn2ForCostWhenAmountIs1AndQuantityIs2() {
        moneyOne = new Money(1);
        Quantity quantity = new Quantity(2);

        actualAmount = moneyOne.getCost(quantity);
        expectedAmount = new Money(2);

        Assert.assertEquals(actualAmount, expectedAmount);
    }
}
