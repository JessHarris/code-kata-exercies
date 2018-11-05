package test.java;

import main.java.Checkout;
import main.java.PricingRule;
import main.java.PricingRules;
import main.java.TwoForOneRule;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CheckoutTest {
    private PricingRules pricingRules;

    @Before
    public void createPricingRules(){
        TwoForOneRule rule = new TwoForOneRule("A", 1.0);
        List<PricingRule> ruleList = new ArrayList<>();
        ruleList.add(rule);

        pricingRules = new PricingRules(ruleList);
    }

    @Test
    public void testTotals(){
        assertEquals(0.0, price(""));
        assertEquals(1.0, price("A"));
        assertEquals(1.0, price("AA"));
        assertEquals(2.0, price("AAA"));
        assertEquals(2.0, price("AAAA"));
        assertEquals(3.0, price("AAAAA"));
        assertEquals(3.0, price("AAAAAB"));
        assertEquals(0.0, price("B"));
    }

    private double price(String goods){
        Checkout co = new Checkout(pricingRules);

        String [] itemsArray = goods.split("");
        List<String> items = Arrays.asList(itemsArray);
        for(String s : items){
            co.scan(s);
        }

        return co.calculateTotal();
    }
}
