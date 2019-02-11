package com.denis.interview.patterns.behavioral.strategy.shoppingcart;


import com.denis.interview.patterns.behavioral.strategy.interfaces.PaymentStrategy;
import com.denis.interview.patterns.behavioral.strategy.items.Item;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items;


    public ShoppingCart() {
        this.items = new ArrayList<>();
    }


    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    private int calculateTotal() {

        int sum = 0;

        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }

}
