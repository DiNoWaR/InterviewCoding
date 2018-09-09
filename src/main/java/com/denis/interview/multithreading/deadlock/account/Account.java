package com.denis.interview.multithreading.deadlock.account;


public class Account implements Comparable<Account> {

    private long id;
    private long balance;


    public void transfer(Account first, Account second, int amount) {

        Account from = first;
        Account to = second;

        if (from.compareTo(to) < 0) {
            from = second;
            to = first;
        }

        synchronized (from) {
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    private void deposit(int amount) {
        balance += amount;
    }

    private void withdraw(int amount) {
        balance -= amount;
    }


    public long getId() {
        return id;
    }


    @Override
    public int compareTo(Account o) {

        if (o.getId() > this.id) {
            return 1;
        }
        return -1;
    }
}
