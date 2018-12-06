package test.java;

import main.java.checkoutKata.Quantity;
import org.junit.Assert;
import org.junit.Test;

public class QuantityTest {
    private Quantity quantity;
    private Quantity expectedQuantity;
    private Quantity actualQuantity;
    private Quantity discountQuantity;

    @Test
    public void whenIncrementedQuantityIncreasesByOne(){
        quantity = new Quantity(1);
        actualQuantity = quantity.incrementQuantity();
        expectedQuantity = new Quantity(2);

        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void whenQuantityIs4AndDiscountQuantityIs2DivideReturns2(){
        quantity = new Quantity(4);
        discountQuantity = new Quantity(2);

        actualQuantity = quantity.divide(discountQuantity);
        expectedQuantity = new Quantity(2);

        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void whenQuantityIs5AndDiscountQuantityIs2RemainderReturns1(){
        quantity = new Quantity(5);
        discountQuantity = new Quantity(2);

        actualQuantity = quantity.remainder(discountQuantity);
        expectedQuantity = new Quantity(1);

        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void returnsQuantityAsInt(){
        quantity = new Quantity(5);

        int actualQuantity = quantity.getAsInt();
        int expectedQuantity = 5;

        Assert.assertEquals(expectedQuantity, actualQuantity);
    }
}
