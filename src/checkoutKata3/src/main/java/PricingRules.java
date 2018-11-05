package main.java;

import java.util.List;

public class PricingRules {

    private final List<PricingRule> pricingRules;

    public PricingRules(List<PricingRule> pricingRules){
        this.pricingRules = pricingRules;
    }

    public void applyRules(Item item){
        for(PricingRule rule : pricingRules){
            rule.applyRule(item);
        }
    }

}
