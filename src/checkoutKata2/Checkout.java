package checkoutKata2;


public class Checkout {
    private Items items;
    private PricingRules rules;

    public Checkout(PricingRules rules){
        this.rules = rules;
        items = new Items();
    }

    public void scan(String itemCode){
        Item item = items.getItem(itemCode);
        item.incrementItemCount();
        rules.applyRules(item);
    }

    public double calculateTotalCostOfItems(){
        return items.calculateTotalCostOfItems();
    }

}
