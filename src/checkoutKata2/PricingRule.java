package checkoutKata2;

public interface PricingRule {
    public boolean shouldApplyRule(Item item);
    public Item applyRule(Item item);
}
