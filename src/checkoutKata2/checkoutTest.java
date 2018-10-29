package checkoutKata2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class checkoutTest {

    @Test
    public void totalIsCalculatedForItemWithTwoForOnePricingRule(){
        TwoForOnePricingRule rule = new TwoForOnePricingRule("A");
        List<PricingRule> rulesList = new ArrayList<>();
        rulesList.add(rule);

        Checkout co = new Checkout(new PricingRules(rulesList));
        co.scan("A");
        co.scan("A");
        assertEquals(1.0, co.calculateTotalCostOfItems());
    }

    @Test
    public void totalIsCalculatedWithBothDiscountedAndNonDiscountedItems(){
        TwoForOnePricingRule rule = new TwoForOnePricingRule("A");
        List<PricingRule> rulesList = new ArrayList<>();
        rulesList.add(rule);

        Checkout co = new Checkout(new PricingRules(rulesList));
        co.scan("A");
        co.scan("A");
        co.scan("B");
        co.scan("B");
        assertEquals(5.0, co.calculateTotalCostOfItems());
    }
}
