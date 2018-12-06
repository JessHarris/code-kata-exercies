package test.java;

import main.java.checkoutKata.ItemCode;
import org.junit.Assert;
import org.junit.Test;

public class ItemCodeTest {
    private ItemCode itemCodeOne;
    private ItemCode itemCodeTwo;

    @Test
    public void shouldReturnTrueWhenTwoItemCodesAreEqual() {
        itemCodeOne = new ItemCode("A");
        itemCodeTwo = new ItemCode("A");

        Assert.assertTrue(itemCodeOne.equals(itemCodeTwo));
    }

    @Test
    public void shouldReturnFalseWhenTwoItemCodesAreNotEqual() {
        itemCodeOne = new ItemCode("A");
        itemCodeTwo = new ItemCode("B");

        Assert.assertFalse(itemCodeOne.equals(itemCodeTwo));
    }
}
