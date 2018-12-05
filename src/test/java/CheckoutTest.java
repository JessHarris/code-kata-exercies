package test.java;

import main.java.checkoutKata.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckoutTest {
    private List<Rule> ruleList = new ArrayList<>();

    @Before
    public void initializeRules(){
        Rule emptyRule = new PriceRule("", 0,0,0);
        Rule itemARule = new PriceRule("A", 50, 3, 130);
        Rule itemBRule = new PriceRule("B", 30, 2, 45);

        ruleList.add(emptyRule);
        ruleList.add(itemARule);
        ruleList.add(itemBRule);
    }

    @Test
    public void whenNothingIsScannedTotalIsZero(){
        Checkout checkout = new Checkout(ruleList);
        checkout.scan(new ItemCode(""));

        Money actualTotal = checkout.total();
        Money expectedTotal = new Money(0);

        Assert.assertEquals(expectedTotal, actualTotal);
    }

    @Test
    public void whenItemAIsScannedTotalShouldBe50(){
        Checkout checkout = new Checkout(ruleList);
        checkout.scan(new ItemCode("A"));

        Money actualTotal = checkout.total();
        Money expectedTotal = new Money(50);

        Assert.assertEquals(expectedTotal, actualTotal);

    }


    @Test
    public void whenItemBIsScannedTotalShouldBe30(){
        Checkout checkout = new Checkout(ruleList);
        checkout.scan(new ItemCode("B"));

        Money actualTotal = checkout.total();
        Money expectedTotal = new Money(30);

        Assert.assertEquals(expectedTotal, actualTotal);

    }

    @Test
    public void whenItemAAndItemBIsScannedTotalShouldBe80(){
        Checkout checkout = new Checkout(ruleList);
        checkout.scan(new ItemCode("A"));
        checkout.scan(new ItemCode("B"));

        Money actualTotal = checkout.total();
        Money expectedTotal = new Money(80);

        Assert.assertEquals(expectedTotal, actualTotal);

    }

    @Test
    public void whenThreeAItemsAreScannedTotalShouldBe130(){
        Checkout checkout = new Checkout(ruleList);
        checkout.scan(new ItemCode("A"));
        checkout.scan(new ItemCode("A"));
        checkout.scan(new ItemCode("A"));

        Money actualTotal = checkout.total();
        Money expectedTotal = new Money(130);

        Assert.assertEquals(expectedTotal, actualTotal);

    }

    @Test
    public void whenTwoBItemsAreScannedTotalShouldBe45(){
        Checkout checkout = new Checkout(ruleList);
        checkout.scan(new ItemCode("B"));
        checkout.scan(new ItemCode("B"));

        Money actualTotal = checkout.total();
        Money expectedTotal = new Money(45);

        Assert.assertEquals(expectedTotal, actualTotal);

    }

    @Test
    public void whenThreeAItemsAndTwoBItemsAreScannedTotalShouldBe175(){
        Checkout checkout = new Checkout(ruleList);
        checkout.scan(new ItemCode("A"));
        checkout.scan(new ItemCode("A"));
        checkout.scan(new ItemCode("A"));
        checkout.scan(new ItemCode("B"));
        checkout.scan(new ItemCode("B"));

        Money actualTotal = checkout.total();
        Money expectedTotal = new Money(175);

        Assert.assertEquals(expectedTotal, actualTotal);

    }

}
