package main.java.checkoutKata;

public interface Rule {

    public abstract Money applyRule(Quantity quantity);
    public abstract boolean shouldApplyRule(ItemCode itemCode);
}
