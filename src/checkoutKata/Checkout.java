package checkoutKata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Checkout {
    private Map<String, Item> itemMap = new HashMap<>();
    private List<Discount> discounts = new ArrayList<>();
    private static final Map<String, Double> regularPrice;
    private double totalCost;

    static {
        regularPrice = new HashMap<>();
        regularPrice.put("A", 1.0);
        regularPrice.put("B", 2.0);
        regularPrice.put("C", 3.0);

    }

    public Checkout(List<Discount> discounts) {
        this.discounts = new ArrayList<>(discounts);
    }

    public void scan(String itemCode) {
        //Check to see if this item has been scanned before if so increment count if not create new item
        Item item = itemMap.get(itemCode);

        if (item != null) {
            item.setQuantity(item.getQuantity() + 1);
        } else {
            item = new Item(itemCode, regularPrice.get(itemCode), 1);
            itemMap.put(itemCode, item);
        }

        //Calculate cost of item with new quantity
        item.calculateCost();
        checkIfDiscountExistsForItemAndApply(item);
    }

    public double calculateTotalCost() {
        totalCost = 0;
        for (Item value : itemMap.values()) {
            totalCost += value.getCost();
        }
        return totalCost;
    }

    private void checkIfDiscountExistsForItemAndApply(Item item) {
        for (Discount discount : discounts) {
            if (discount.getItemCode().equals(item.getItemCode())) {
                discount.calculateDiscount(item);
            }
        }
    }
}
