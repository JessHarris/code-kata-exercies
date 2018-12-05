package main.java.checkoutKata;
import java.util.*;
public class Rules {

    private final List<Rule> rulesList;

    public Rules(List<Rule> rules){
        this.rulesList = rules;
    }

    public Money applyRules(Items items){
        Money total = new Money(0);
       for(Map.Entry<ItemCode, Quantity> entry : items.entries()){
           Rule ruleToUse = findRuleToUse(entry.getKey());
           Money costOfItem= applyMatchingRule(ruleToUse, entry.getValue());
           total = total.add(costOfItem);
       }
        return total;
    }

    private Rule findRuleToUse(ItemCode itemCode){
        Rule ruleToUse = null;
        for(Rule rule : rulesList){
          ruleToUse = checkRule(rule,itemCode) ? rule : null;
          if(ruleToUse != null){
              break;
          }
        }
        return ruleToUse;
    }

    private Money applyMatchingRule(Rule rule, Quantity quantity){
        return rule.applyRule(quantity);
    }

    private boolean checkRule(Rule rule, ItemCode itemCode){
        return rule.shouldApplyRule(itemCode);
    }

}
