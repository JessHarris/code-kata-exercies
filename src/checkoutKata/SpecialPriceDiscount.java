package checkoutKata;

public class SpecialPriceDiscount implements Discount {
    private String discountItemCode;
    private double discountItemPrice;
    private int discountItemQuantity;


    public SpecialPriceDiscount(String discountItemCode, double discountItemPrice, int discountItemQuantity){
        this.discountItemCode = discountItemCode;
        this.discountItemPrice = discountItemPrice;
        this.discountItemQuantity = discountItemQuantity;
    }


    @Override
    public void calculateDiscount(Item item) {
        int quantity = item.getQuantity();
        double regularPrice = item.getPrice();

        int discountedItems = quantity / discountItemQuantity;
        int regularPriceItem = quantity % discountItemQuantity;

        item.setCost((discountedItems * discountItemPrice) + (regularPriceItem * regularPrice));
    }

    @Override
    public String getItemCode() {
        return discountItemCode;
    }
}
