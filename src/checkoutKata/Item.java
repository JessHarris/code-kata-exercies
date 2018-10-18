package checkoutKata;

public class Item {
    private String itemCode;
    private double price;
    private int quantity;
    private double cost;

    public Item (String itemCode, double price, int quantity){
        this.itemCode = itemCode;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void calculateCost(){
        cost = quantity * price;
    }
}
