package main.java.checkoutKata;

import java.util.Objects;

public class Quantity {
    private int quantity;

    public Quantity(int quanity){
        this.quantity = quanity;
    }


    public Quantity incrementQuantity(){
        return new Quantity(this.quantity + 1);
    }

    public Quantity getDiscountedItems(Quantity otherQuantity){
        int other = otherQuantity.getAsInt();
        return new Quantity(this.quantity /other);
    }

    public Quantity getRegularPriceItems(Quantity otherQuantity){
        int other = otherQuantity.getAsInt();
        return new Quantity(this.quantity % other);
    }

    public int getAsInt(){
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return quantity == quantity1.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
