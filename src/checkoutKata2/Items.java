package checkoutKata2;

import java.util.*;

public class Items {

    private Map<String, Item> items;

    public Items(){
        items = new HashMap<>();
        items.put("A", new Item(0.0, 0, 1.0, "A"));
        items.put("B", new Item(0.0, 0, 2.0, "B"));
        items.put("C", new Item(0.0, 0, 3.0, "C"));
    }

    public Item getItem(String itemCode){
        return items.get(itemCode);
    }

    public double calculateTotalCostOfItems(){
        double totalCost = 0.0;
        for(Item item : items.values()){
           calculateCostIfItemHasNoDiscount(item);
           totalCost = totalCost + item.getItemCost();
        }
        return totalCost;
    }

    public void calculateCostIfItemHasNoDiscount(Item item){
        int itemCount = item.getItemCount();
        double itemCost = item.getItemCost();
        double regularPrice =item.getRegularPrice();

        if(itemCount > 0 && itemCost == 0.0){
            item.setItemCost(itemCount * regularPrice);
        }

    }
}
