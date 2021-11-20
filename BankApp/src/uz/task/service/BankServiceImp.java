package uz.task.service;

import uz.task.model.Account;
import uz.task.model.Client;
import uz.task.model.Result;

import java.util.Arrays;
import java.util.Scanner;

public class BankServiceImp implements BankService {

    protected Client[] clients = new Client[10];
    protected Account account;
    Scanner scanner;

    public BankServiceImp() {
        this.account = new Account();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String clientInfo() {
        return "BankServiceImp{" +
                "clients=" + Arrays.toString(clients) +
                '}';
    }

    @Override
    public Result addBalance() {
        scanner = new Scanner(System.in);
        Result result = new Result();
        System.out.print("INN : ");
        String inn = scanner.nextLine();
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                if (inn.equals(clients[i].getInn())) {
                    System.out.print("Sum: ");
                    clients[i].getAccount().setBalance(scanner.nextDouble());
                    result.setMessage("Sum is added to client's balance!");
                    return result;
                }
            }
        }
        result.setMessage("Clients not found!");
        return result;
    }

    @Override
    public Result withDraw() {
        scanner = new Scanner(System.in);
        Result result = new Result();
        System.out.print("INN : ");
        String inn = scanner.nextLine();
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                if (inn.equals(clients[i].getInn())) {
                    System.out.print("Sum: ");
                    clients[i].getAccount().setBalance(-scanner.nextDouble());
                    result.setMessage("Sum is withdrawn from client's balance!");
                    return result;
                }
            }
        }
        result.setMessage("Clients not found!");
        return result;
    }

    @Override
    public Result transfer() {
        scanner = new Scanner(System.in);
        Result result = new Result();
        System.out.print("INN : ");
        String inn = scanner.nextLine();
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                if (inn.equals(clients[i].getInn())) {
                    System.out.print("Receiver inn: ");
                    String receiverInn = scanner.nextLine();
                    for (int j = 0; j < clients.length; j++) {
                        if (clients[i] != null) {
                            if (receiverInn.equals(clients[i].getInn())) {
                                System.out.print("Sum: ");
                                double sum = scanner.nextDouble();
                                double percent = sum * 0.01;
                                if (clients[i].getAccount().getBalance() >= sum + percent) {
                                    clients[i].getAccount().setBalance(-(sum + percent));
                                    clients[j].getAccount().setBalance(sum);
                                    getAccount().setBalance(percent);
                                    result.setMessage("Transfer is completed succesfully.");
                                    result.setSucces(true);
                                    return result;
                                } else {
                                    result.setMessage("Not enough money in your balance!!!");
                                }
                            } else {
                                result.setMessage("Reciever client is not founded!!!");
                            }
                        } else {
                            result.setMessage("Reciever client is not found!!!");
                        }
                    }
                } else {
                    result.setMessage("Client is not founded!!!");
                }
            } else {
                result.setMessage("Client is not founded!!!");
            }
        }
        return result;
    }

    @Override
    public Result addAccount() {
        Result result = new Result();
        Client client;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                client = new Client();
                clients[i] = client;
                result.setMessage("Account is succesfully added!!!");
                result.setSucces(true);
                return result;
            }
        }
        result.setMessage("There is no free place!!!");
        return result;
    }
}
