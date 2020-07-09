package dev.n8git.detroitlabstest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class OrderController {

    // `calculateTotal` doesn't validate input. It expects that the order has already been validated.
    protected static Total calculateTotal(Order order) {
        int totalCents = order.getChorizoCount() * order.chorizoCents;
        totalCents += order.getBeefOrChickenCount() * order.beefOrChickenCents;
        totalCents += order.getVeggieCount() * order.veggieCents;

        if (order.totalItemCount >= order.itemsNeededForDiscount) {
            totalCents -= totalCents * order.discountPct;
        }

        return new Total(totalCents);
    }

    @PostMapping(path = "/order")
    public Total orderHandler(@Valid @RequestBody Order order) {
        return calculateTotal(order);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getMessage();
    }
}
