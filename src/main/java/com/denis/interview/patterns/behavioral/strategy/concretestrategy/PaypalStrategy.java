package com.denis.interview.patterns.behavioral.strategy.concretestrategy;


import com.denis.interview.patterns.behavioral.strategy.interfaces.PaymentStrategy;

public class PaypalStrategy implements PaymentStrategy {

    private String emailId;
    private String password;


    public PaypalStrategy(String email, String password) {
        this.emailId = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }
}
