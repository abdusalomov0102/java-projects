package uz.task;

import uz.task.model.Bank;
import uz.task.model.Result;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        System.out.println(bank.toString());

        while (true) {
            System.out.println("1 :=> Add Account          2 :=> Withdraw          3 :=> Bank Info\n" +
                    "4 :=> Add Balance          5 :=> Transfer          6 :=> Clients Info\n" +
                    "                           0 :=> Exit");
            switch (scanner.nextByte()) {
                case 0:
                    return;
                case 1:
                    Result result1 = bank.addAccount();
                    if (result1.isSucces()) {
                        System.out.println(result1.getMessage());
                    } else {
                        System.err.println(result1.getMessage());
                    }
                    break;
                case 2:
                    Result result2 = bank.withDraw();
                    if (result2.isSucces()) {
                        System.out.println(result2.getMessage());
                    } else {
                        System.err.println(result2.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(bank.toString());
                    break;
                case 4:
                    Result result3 = bank.addBalance();
                    if (result3.isSucces()) {
                        System.out.println(result3.getMessage());
                    } else {
                        System.err.println(result3.getMessage());
                    }
                    break;
                case 5:
                    Result result4 = bank.transfer();
                    if (result4.isSucces()) {
                        System.out.println(result4.getMessage());
                    } else {
                        System.err.println(result4.getMessage());
                    }
                    break;
                case 6:
                    System.out.println(bank.clientInfo());
                    break;
                default:
                    System.err.println("Wrong option!!!");
            }
        }

    }
}
