package main.java;

import java.util.HashMap;
import java.util.Map;

public class Items {

    private final Map<String, Item> itemsMap = new HashMap<>();

    public Item getItemInformation(String itemCode){
        Item item = itemsMap.containsKey(itemCode) ? itemsMap.get(itemCode) : new Item(itemCode);
        item.incrementCount();
        itemsMap.put(itemCode, item);
        return item;
    }

    public double calculateTotal(){
        double finalTotal = 0.0;
        for(Item item : itemsMap.values()){
            finalTotal += item.getTotalCostOfItem();
        }
        return finalTotal;
    }

}
