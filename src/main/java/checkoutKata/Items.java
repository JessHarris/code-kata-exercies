package main.java.checkoutKata;
import java.util.*;


public class Items {

    private final Map<ItemCode, Quantity> itemMap;

    public Items(){
        itemMap = new HashMap<>();
    }

    public Set<Map.Entry<ItemCode, Quantity>> entries(){
        return itemMap.entrySet();
    }

    public void checkForItem(ItemCode itemCode){
        if(itemExists(itemCode)){
            updateItemQuantity(itemCode);
        }else{
            createNewItem(itemCode);
        }
    }
    private boolean itemExists(ItemCode itemCode){
        return itemMap.containsKey(itemCode);
    }

    private void updateItemQuantity(ItemCode itemCode){
        Quantity quantity = itemMap.get(itemCode);
        Quantity incrementedQuantity = quantity.incrementQuantity();
        itemMap.put(itemCode, incrementedQuantity);
    }

    private void createNewItem(ItemCode itemCode){
        itemMap.put(itemCode, new Quantity(1));
    }
}
