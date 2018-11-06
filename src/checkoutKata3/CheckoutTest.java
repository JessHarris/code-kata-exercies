package checkoutKata3;

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
        RegularPriceRule regularPriceRule= new RegularPriceRule("B", 2.0);
        HalfOffRule halfOffRule = new HalfOffRule("C", 5.0);

        List<PricingRule> ruleList = new ArrayList<>();
        ruleList.add(rule);
        ruleList.add(regularPriceRule);
        ruleList.add(halfOffRule);

        pricingRules = new PricingRules(ruleList);
    }

    @Test
    public void testTotals(){
        assertEquals(  0.0, price(""));
        assertEquals( 1.0, price("A"));
        assertEquals( 1.0, price("AA"));
        assertEquals( 3.0, price("AB"));
        assertEquals( 3.0, price("AAB"));
        assertEquals( 2.5, price("C"));

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