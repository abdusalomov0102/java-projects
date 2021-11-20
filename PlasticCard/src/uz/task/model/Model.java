package uz.task.model;

import java.util.Date;
import java.util.Scanner;

public class Model {

    private String bankName;
    private String cardSystem;
    private String accountNumber;
    private String expireDate;
    private String owner;
    private String pincode;
    private double balance;
    private boolean block;

    public Model (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bank Name: ");
        bankName = scanner.nextLine();
        cardSystem = "UZ CARD";
        expireDate = expireDate();
        accountNumber = generationAccount();
        System.out.print("Owner : ");
        owner = scanner.nextLine();
        System.out.print("Pin Code : ");
        pincode=scanner.nextLine();
        block=false;
    }


    public String expireDate(){
        Date date = new Date();
        String expireDate = (date.getMonth()+"/"+(date.getYear()%100+5));
        if (expireDate.length()==4){
            expireDate="0"+expireDate;
        }
        return expireDate;
    }

    public String generationAccount(){
        String accountNumber = "8600";
        Date date = new Date();
        String time = String.valueOf(date.getTime());
        accountNumber+=" "+time.substring(0,4)+ " "
                +time.substring(4,8)+" "+time.substring(8,12);
        return accountNumber;
    }

    public Model(String bankName, String cardSystem, String accountNumber, String expireDate, String owner, double balance, String pincode, boolean block) {
        this.bankName = bankName;
        this.cardSystem = cardSystem;
        this.accountNumber = accountNumber;
        this.expireDate = expireDate;
        this.owner = owner;
        this.balance = balance;
        this.pincode = pincode;
        this.block = block;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardSystem() {
        return cardSystem;
    }

    public void setCardSystem(String cardSystem) {
        this.cardSystem = cardSystem;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "ModelCard{\n" +
                "bankName='" + bankName + '\'' +
                ", cardSystem='" + cardSystem + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", \nexpireDate='" + expireDate + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                ", pincode='" + pincode + '\'' +
                ", block=" + block +
                "\n}";
    }

}
