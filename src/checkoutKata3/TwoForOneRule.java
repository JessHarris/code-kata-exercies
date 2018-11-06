package checkoutKata3;

public class TwoForOneRule implements PricingRule {
    private final String itemCode;
    private final double price;

    public TwoForOneRule(String itemCode, double price){
        this.itemCode = itemCode;
        this.price = price;
    }

    @Override
    public void applyRule(Item item){
        String code = item.getItemCode();
        if(!itemCode.equals(code)){
            return;
        }
        int itemCount = item.getQuantity();

        int discountedItems = itemCount / 2;
        int regularPriceItem = itemCount % 2;

        item.setTotalCostOfItem((discountedItems * price) + (regularPriceItem * price));
    }

}
