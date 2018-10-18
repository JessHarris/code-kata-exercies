package checkoutKata;

public interface Discount {

    public abstract void calculateDiscount(Item item);
    public abstract String getItemCode();
}
