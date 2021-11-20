package uz.task.model;


import uz.task.service.BankServiceImp;
import uz.task.utils.Utils;

import java.util.Scanner;

public class Bank extends BankServiceImp {

    private String name;
    private String INN;
    private String MFO;

    public Bank() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bank Name : ");
        name = scanner.nextLine();
        System.out.print("MFO : ");
        MFO = scanner.nextLine();
        this.INN = Utils.generateINN();
    }

    public Bank(String name, String INN, String MFO) {
        this.name = name;
        this.INN = INN;
        this.MFO = MFO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getMFO() {
        return MFO;
    }

    public void setMFO(String MFO) {
        this.MFO = MFO;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", INN='" + INN + '\'' +
                ", MFO='" + MFO + '\'' +
                '}';
    }
}
