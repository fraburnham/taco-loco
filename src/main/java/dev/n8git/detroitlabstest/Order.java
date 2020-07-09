package dev.n8git.detroitlabstest;

import javax.validation.constraints.Min;

public class Order {

    @Min(value = 0, message = "Item count cannot be negative")
    private final int veggieCount;

    @Min(value = 0, message = "Item count cannot be negative")
    private final int beefOrChickenCount; // not sure if this is one or two menu options...

    @Min(value = 0, message = "Item count cannot be negative")
    private final int chorizoCount;

    @Min(value = 1, message = "Order must contain at least one item")
    protected final int totalItemCount;

    public final int veggieCents = 250;
    public final int beefOrChickenCents = 300;
    public final int chorizoCents = 350;
    public final int itemsNeededForDiscount = 4;
    public final double discountPct = 0.2;

    public Order(int veggieCount, int beefOrChickenCount, int chorizoCount) {
        this.veggieCount = veggieCount;
        this.beefOrChickenCount = beefOrChickenCount;
        this.chorizoCount = chorizoCount;
        this.totalItemCount = this.getChorizoCount() + this.getBeefOrChickenCount() + this.getVeggieCount();
    }

    public int getVeggieCount() {
        return this.veggieCount;
    }

    public int getBeefOrChickenCount() {
        return this.beefOrChickenCount;
    }

    public int getChorizoCount() {
        return this.chorizoCount;
    }
}