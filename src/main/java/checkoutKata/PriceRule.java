package main.java.checkoutKata;

public class PriceRule implements Rule {
    private final ItemCode itemCode;
    private final Money normalPrice;
    private final Quantity specialQuantity;
    private final Money specialPrice;

    public PriceRule(String itemCode, int normalPrice, int specialQuantity, int specialPrice) {
        this.itemCode = new ItemCode(itemCode);
        this.normalPrice = new Money(normalPrice);
        this.specialQuantity = new Quantity(specialQuantity);
        this.specialPrice = new Money(specialPrice);
    }

    @Override
    public Money applyRule(Quantity quantity) {
        boolean hasDiscount = !specialQuantity.equals(new Quantity(0));

        Quantity discountedItemsQuantity = hasDiscount ? quantity.getDiscountedItems(specialQuantity) : new Quantity(0);
        Quantity regularPriceItemsQuantity = hasDiscount ? quantity.getRegularPriceItems(specialQuantity) : quantity;

        Money discountedItemsCost = specialPrice.getCost(discountedItemsQuantity);
        Money regularItemsCost = normalPrice.getCost(regularPriceItemsQuantity);

        return discountedItemsCost.add(regularItemsCost);
    }

    @Override
    public boolean shouldApplyRule(ItemCode itemCode) {
        return this.itemCode.equals(itemCode);
    }

}