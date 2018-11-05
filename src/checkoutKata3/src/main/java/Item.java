package main.java;

public class Item {
    private String itemCode;
    private int quantity;
    private double totalCostOfItem;

    public Item(String itemCode){
        this.itemCode = itemCode;
    }

    public String getItemCode() {

        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementCount(){
        this.quantity += 1;
    }
    public void setTotalCostOfItem(double totalCostOfItem) {
        this.totalCostOfItem = totalCostOfItem;
    }

    public double getTotalCostOfItem() {
        return totalCostOfItem;
    }
}
