package uz.java.service;

import uz.java.model.ModelCard;

import java.util.Scanner;

public class ServicesCard {

    public void Bankomat(ModelCard modelCard) {
        Scanner scanner = new Scanner(System.in);
        int attempTime = 0;
        while (true) {
            System.out.print("Pin Code : ");
            String pinCode = scanner.nextLine();
            if (pinCode.equals(modelCard.getPincode())) {
                if (modelCard.isBlock()) {
                    System.err.println("This card is already blocked!!!");
                } else {
                    while (true) {
                        scanner = new Scanner(System.in);
                        System.out.println("\n0 => Unhook the Card             1 => Take Money\n" +
                                "2 => View Money                  3 => Change Pin");
                        switch (scanner.nextInt()) {
                            case 0:
                                return;
                            case 1:
                                takeMoney(modelCard);
                                break;
                            case 2:
                                viewMoney(modelCard);
                                break;
                            case 3:
                                changePin(modelCard);
                                break;
                            default:
                                System.err.println("Wrong chance!!!");
                        }
                    }
                }
            } else {
                attempTime++;
                if (attempTime == 3) {
                    modelCard.setBlock(true);
                    System.err.println("Card is blocked!!!");
                    return;
                } else {
                    System.err.println("If you enter " + (3 - attempTime) + " time, Card will be blocked!!!");
                }
            }
        }
    }

    public void changePin(ModelCard modelCard) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            while (true) {
                System.out.print("Enter new Pin : ");
                String newPin = scanner.nextLine();
                if (newPin.length() == 4) {
                    boolean bool = true;
                    for (int i = 0; i < newPin.length(); i++) {
                        if (newPin.charAt(i) >= 48 && newPin.charAt(i) <= 57) {
                            continue;
                        } else {
                            System.err.println("Pin must be only number!!!");
                            bool = false;
                            break;
                        }
                    }
                    if (bool) {
                        while (true) {
                            System.out.print("Confirm pin code : ");
                            String confirmPin = scanner.nextLine();
                            if (newPin.equals(confirmPin)) {
                                modelCard.setPincode(newPin);
                                System.out.println("The pin is changed succesfully.");
                                return;
                            } else {
                                System.err.println("Wrong confirmation pin.");
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                } else {
                    System.err.println("You can use only 4 numbers as a pin!!!");
                }
            }
        }
    }

    public void Terminal(ModelCard modelCard) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Pin : ");
        String pinTer = scanner.nextLine();
        if (modelCard.getPincode().equals(pinTer)) {
            while (true) {
                System.out.println("0 => Exit          1 => View Money          2 => Take Money");
                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        viewMoney(modelCard);
                        break;
                    case 2:
                        takeMoney(modelCard);
                        break;
                    default:
                        System.err.println("Wrong chance!!!");
                }
            }
        } else {
            System.err.println("You enter wrong pin code!!!");
        }
    }

    public void takeMoney(ModelCard modelCard) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much money : ");
        double sum = scanner.nextDouble();
        if (modelCard.getBalance() >= sum) {
            modelCard.setBalance(modelCard.getBalance() - sum);
            System.out.println("You can take " + sum + " so'm.");
        } else {
            System.err.println("There is not enough money in your card.");
        }
    }

    public void viewMoney(ModelCard modelCard) {
        System.out.println("There is " + modelCard.getBalance() + " sum in your card.");
    }

    public void unblockCard(ModelCard modelCard) {
        if (modelCard.isBlock()) {
            modelCard.setBlock(false);
            System.out.println("The card is unblocked.");
        } else {
            System.err.println("Card is not blocked!!!");
        }
    }

}