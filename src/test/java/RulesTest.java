package test.java;

import main.java.checkoutKata.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RulesTest {

    private List<Rule> ruleList;
    private Rule rule;
    private Items items;
    private Rules rules;

    @Before
    public void setUp(){
        ruleList = new ArrayList<>();
        rule = new PriceRule("A", 50, 3, 130);
        ruleList.add(rule);
        rules = new Rules(ruleList);
    }

    @Test
    public void applyPriceRuleAForItemAAndCalculateCorrectCost() {
        items = new Items();
        items.checkForItem(new ItemCode("A"));

        Money expectedMoney = new Money(50);
        Money actualMoney = rules.applyRules(items);

        Assert.assertEquals(expectedMoney, actualMoney);
    }
}
