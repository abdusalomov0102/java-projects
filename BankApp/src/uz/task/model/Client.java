package uz.task.model;

import uz.task.utils.Utils;

import java.util.Scanner;

public class Client {

    private String fullName;
    private Account account;
    private String phone;
    private String address;
    private String inn;
    private boolean type;   // Jismoniy - true,         Yuridik - false;

    public Client() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Full Name : ");
        fullName = scanner.nextLine();
        account = new Account();
        System.out.print("Phone : ");
        phone = scanner.nextLine();
        System.out.print("Adress : ");
        address = scanner.nextLine();
        this.inn = Utils.generateINN();
        System.out.println("Yype of account \n1 :=> Jismoniy            2 :=> Yuridik");
        if (scanner.nextByte() == 1) {
            this.type = true;
        }
    }

    public Client(String fullName, Account account, String phone, String address, String inn, boolean type) {
        this.fullName = fullName;
        this.account = account;
        this.phone = phone;
        this.address = address;
        this.inn = inn;
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
