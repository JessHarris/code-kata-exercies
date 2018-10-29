package checkoutKata2;

public class Item {
    private String itemCode;
    private double itemCost;
    private int itemCount;
    private double regularPrice;

    public Item(double itemCost, int itemCount, double regularPrice, String itemCode){
        this.itemCost = itemCost;
        this.itemCount = itemCount;
        this.regularPrice = regularPrice;
        this.itemCode = itemCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void incrementItemCount(){
        itemCount = itemCount + 1;
    }

    public void setItemCost(double cost){
        itemCost = cost;
    }

    public double getItemCost(){
        return itemCost;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }
}
