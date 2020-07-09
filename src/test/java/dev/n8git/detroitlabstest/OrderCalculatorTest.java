package dev.n8git.detroitlabstest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderCalculatorTest extends Assertions {

    @Test
    public void verifyCalculations() {
        Order order;
        Total total;

        // order a veggie taco expecting 250c total
        order = new Order(1, 0, 0);
        total = OrderController.calculateTotal(order);
        assertEquals(250, total.getTotalCents());

        // order a beef or chicken taco expecting 300c total
        order = new Order(0, 1, 0);
        total = OrderController.calculateTotal(order);
        assertEquals(300, total.getTotalCents());

        // order a chorizo expecting 350c total
        order = new Order(0, 0, 1);
        total = OrderController.calculateTotal(order);
        assertEquals(350, total.getTotalCents());

        // order 2x veg 1x boc 1x chorizo expecting 920c total
        order = new Order(2, 1, 1);
        total = OrderController.calculateTotal(order);
        assertEquals(920, total.getTotalCents());

        // order 10x veg expecting 2000c total
        order = new Order(10, 0, 0);
        total = OrderController.calculateTotal(order);
        assertEquals(2000, total.getTotalCents());
    }
}
