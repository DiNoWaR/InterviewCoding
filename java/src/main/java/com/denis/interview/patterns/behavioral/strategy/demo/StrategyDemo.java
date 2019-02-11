package com.denis.interview.patterns.behavioral.strategy.demo;


import com.denis.interview.patterns.behavioral.strategy.concretestrategy.CreditCardStrategy;
import com.denis.interview.patterns.behavioral.strategy.concretestrategy.PaypalStrategy;
import com.denis.interview.patterns.behavioral.strategy.items.Item;
import com.denis.interview.patterns.behavioral.strategy.shoppingcart.ShoppingCart;

public class StrategyDemo {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by paypal
        cart.pay(new PaypalStrategy("dinowar1@gmail.com", "myPassword"));

        //pay by credit card
        cart.pay(new CreditCardStrategy("Denis Vasilyev", "1234567890123456", "786", "12/15"));
    }

}
