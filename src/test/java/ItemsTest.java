package test.java;

import main.java.checkoutKata.ItemCode;
import main.java.checkoutKata.Items;
import main.java.checkoutKata.Quantity;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class ItemsTest {
    private ItemCode expectedItemCode;
    private ItemCode actualItemCode;
    private Quantity actualQuantity;
    private Quantity expectedQuantity;

    @Test
    public void whenItemDoesNotExistNewItemWillBeCreatedWithCorrectItemCode() {
        Items items = new Items();
        items.checkForItem(new ItemCode("A"));

        for (Map.Entry<ItemCode, Quantity> entry : items.entries()) {
            actualItemCode = entry.getKey();
        }
        expectedItemCode = new ItemCode("A");
        Assert.assertEquals(actualItemCode, expectedItemCode);
    }

    @Test
    public void whenItemDoesNotExistNewItemWillBeCreatedWithQuantityOne() {
        Items items = new Items();
        items.checkForItem(new ItemCode("A"));

        for (Map.Entry<ItemCode, Quantity> entry : items.entries()) {
            actualQuantity = entry.getValue();
        }
        expectedQuantity = new Quantity(1);
        Assert.assertEquals(actualQuantity, expectedQuantity);
    }

    @Test
    public void whenItemDoesExistItemWillBeUpdatedWithNewQuantity() {
        Items items = new Items();
        items.checkForItem(new ItemCode("A"));
        items.checkForItem(new ItemCode("A"));

        for (Map.Entry<ItemCode, Quantity> entry : items.entries()) {
            actualQuantity = entry.getValue();
        }
        expectedQuantity = new Quantity(2);
        Assert.assertEquals(actualQuantity, expectedQuantity);
    }
}
