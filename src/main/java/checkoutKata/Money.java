package main.java.checkoutKata;

import java.util.Objects;

public class Money {
    private int amount;

    public Money(int amount){
        this.amount = amount;
    }

    public Money getCost(Quantity quantity){
        int quantityAsInt = quantity.getAsInt();
        return new Money(quantityAsInt * amount);
    }

    public Money add(Money otherAmount){
        int otherMoney = otherAmount.getAsInt();
        return new Money(otherMoney + amount);
    }
    public int getAsInt(){
        return this.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
