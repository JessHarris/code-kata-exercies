package checkoutKata2;

public class TwoForOnePricingRule implements PricingRule {

    private String itemCode;

    public TwoForOnePricingRule(String itemCode){
        this.itemCode = itemCode;
    }

    public boolean shouldApplyRule(Item item){
        String itemCode = item.getItemCode();
        if(itemCode.equals(itemCode)){
            return true;
        }
        return false;
    }

    @Override
    public Item applyRule(Item item) {
        int itemCount = item.getItemCount();
        if(itemCount >= 2){
            double regularPrice = item.getRegularPrice();
            int discountedItems = itemCount / 2;
            int regularPriceItem = itemCount % 2;

            item.setItemCost((discountedItems * regularPrice) + (regularPriceItem * regularPrice));
        }
        return item;
    }
}
