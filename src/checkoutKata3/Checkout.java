package checkoutKata3;

public class Checkout {
    private final PricingRules pricingRules;
    private final Items items;

    public Checkout(PricingRules pricingRules){
        this.pricingRules = pricingRules;
        this.items = new Items();
    }

    public void scan(String itemCode){
        Item item = items.getItemInformation(itemCode);
        pricingRules.applyRules(item);

    }

    public double calculateTotal(){
        return items.calculateTotal();
    }
}
