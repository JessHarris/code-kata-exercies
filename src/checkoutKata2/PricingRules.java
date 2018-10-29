package checkoutKata2;

import java.util.ArrayList;
import java.util.List;

public class PricingRules {
    private final List<PricingRule> rules;

    public PricingRules(List<PricingRule> rules){
        this.rules = new ArrayList<>(rules);
    }

    public void applyRules(Item item){
        for(PricingRule rule : rules){
            checkIfRuleShouldBeApplied(rule, item);
        }
    }
    private void checkIfRuleShouldBeApplied(PricingRule rule, Item item){
        if(rule.shouldApplyRule(item)){
            rule.applyRule(item);
        }
    }
}
