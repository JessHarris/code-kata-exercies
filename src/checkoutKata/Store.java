package checkoutKata;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static void main (String [] args){
        Discount discountA = new SpecialPriceDiscount("A", 1, 2);
        Discount discountB = new SpecialPriceDiscount("B", 1.5, 2);
        List<Discount> discountList = new ArrayList<>();
        discountList.add(discountA);
        discountList.add(discountB);

        Checkout co = new Checkout(discountList);

        co.scan("A");
        co.scan("A");
        co.scan("B");
        co.scan("B");

        double totalCost = co.calculateTotalCost();

        System.out.print("TotalCost is " + totalCost);
    }
}
