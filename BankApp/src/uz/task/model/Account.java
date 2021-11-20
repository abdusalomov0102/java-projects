package uz.task.model;

import uz.task.utils.Utils;

public class Account {

    private String Id;
    private double balance;

    public Account() {
        Id = Utils.generateId();
    }

    public Account(String id, double balance) {
        Id = id;
        this.balance = balance;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id='" + Id + '\'' +
                ", balance=" + balance +
                '}';
    }
}
