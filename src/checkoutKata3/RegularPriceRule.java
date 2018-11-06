package checkoutKata3;

public class RegularPriceRule implements PricingRule {
    String itemCode;
    double price;

    public RegularPriceRule(String itemCode, double price){
        this.itemCode = itemCode;
        this.price = price;
    }
    @Override
    public void applyRule(Item item) {
        String code = item.getItemCode();
        if(!itemCode.equals(code)){
            return;
        }
        int quantity = item.getQuantity();
        item.setTotalCostOfItem(quantity * price);
    }
}
