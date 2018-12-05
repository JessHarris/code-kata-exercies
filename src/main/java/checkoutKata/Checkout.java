package main.java.checkoutKata;

import java.util.List;

public class Checkout{
    private final Rules rules;
    private final Items items;

    public Checkout(List<Rule> rules){
        this.rules = new Rules(rules);
        this.items = new Items();
    }

    public Money total(){
        return rules.applyRules(items);

    }

    public void scan(ItemCode itemCode){
        items.checkForItem(itemCode);
    }
}
