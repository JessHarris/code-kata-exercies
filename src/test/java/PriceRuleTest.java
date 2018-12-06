package test.java;

import main.java.checkoutKata.Money;
import main.java.checkoutKata.PriceRule;
import main.java.checkoutKata.Quantity;
import main.java.checkoutKata.Rule;
import org.junit.Assert;
import org.junit.Test;

public class PriceRuleTest {

    private Rule rule;
    private Money expectedMoney;
    private Money actualMoney;
    private Quantity quantity;

    @Test
    public void ruleIsAppliedCorrectlyForItemWithRegularPrice1AndNoDiscount() {
        rule = new PriceRule("A", 1, 0, 0);
        expectedMoney = new Money(1);
        quantity = new Quantity(1);

        actualMoney = rule.applyRule(quantity);
        Assert.assertEquals(actualMoney, expectedMoney);
    }

    @Test
    public void ruleIsAppliedCorrectlyForItemWithRegularPrice2AndDiscountPrice1ForQuantity2() {
        rule = new PriceRule("A", 2, 2, 1);
        expectedMoney = new Money(1);
        quantity = new Quantity(2);

        actualMoney = rule.applyRule(quantity);
        Assert.assertEquals(actualMoney, expectedMoney);
    }
}
