package checkoutKata3;

public class HalfOffRule implements PricingRule {
    String itemCode;
    double price;

    public HalfOffRule(String itemCode, double price){
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
        item.setTotalCostOfItem((price * quantity) / 2);
    }
}
