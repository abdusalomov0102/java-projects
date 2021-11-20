package uz.task.service;

import uz.task.model.Model;

import java.util.Scanner;

public class Service {

    public void Bankomat(Model model){
        Scanner scanner=new Scanner(System.in);
        int attemp=0;
        while (true){
            System.out.print("Pin Code : ");
            String pinCode = scanner.nextLine();
            if (pinCode.equals(model.getPincode())){
                if (model.isBlock()){
                    System.err.println("This Card is already blocked!!!");
                } else {
                    while (true){
                        scanner = new Scanner(System.in);
                        System.out.println("0 => Unhook the Card             1 => View Money" +
                                           "\n2 => Take Money                  3 => Change Pin");
                        switch (scanner.nextInt()){
                            case 0:
                                return;
                            case 1:
                                viewMoney(model);
                                break;
                            case 2:
                                takeMoney(model);
                                break;
                            case 3:
                                changePin(model);
                                break;
                            default:
                                System.err.println("Wrong options!!!");
                        }
                    }
                }
            } else  {
                attemp++;
                if (attemp==3){
                    model.setBlock(true);
                    System.err.println("Card is blocked!!!");
                    return;
                } else {
                    System.err.println("If you enter "+(3-attemp)+ " time, Card will be block!!!");
                }
            }
        }
    }

    public void changePin(Model model){
        Scanner scanner = new Scanner(System.in);
        int i=-1;
        while (i == 0) {
            System.out.print("Enter new Pin : ");
            String  newPin = scanner.nextLine();
            if (newPin.length()==4){
                boolean bool=true;
                for (int j = 0; j < newPin.length(); j++) {
                    if(newPin.charAt(i)>=48 && newPin.charAt(i)<=57){
                        continue;
                    } else {
                        System.err.println("You can only numbers!!!");
                        bool=false;
                        break;
                    }
                }
                if (bool){
                    while (true){
                        System.out.print("Confirm pin code: ");
                        String confirmPin = scanner.nextLine();
                        if (newPin.equals(confirmPin)){
                            model.setPincode(confirmPin);
                            System.out.println("The pin is succesfully changed!!!");
                            return;
                        } else {
                            System.err.println("Wrong Confirmation pin!!!");
                            break;
                        }
                    }
                } else {
                    break;
                }
            }else {
                System.err.println("Pin must be 4 char!!!");
            }
        }
    }

    public void Terminal(Model model){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter Pin code : ");
        String pinConfir = scanner.nextLine();
        if (model.getPincode().equals(pinConfir)){
            System.out.println("0 => Exit          1 => View Money          2 => Take Money");
            switch (scanner.nextInt()){
                case 0:
                    return;
                case 1:
                    viewMoney(model);
                    break;
                case 2:
                    takeMoney(model);
                    break;
                default:
                    System.err.println("Wrong options!!!");
            }
        } else {
            System.err.println("Pin Code is error!!!");
        }
    }

    public void viewMoney(Model model){
        System.out.println("There is "+model.getBalance()+" sum in your Card.");
    }

    public void takeMoney(Model model){
        Scanner scanner=new Scanner(System.in);
        System.out.print("How much money: ");
        double sum = scanner.nextDouble();
        if (model.getBalance()>=sum){
            model.setBalance(model.getBalance()-sum);
            System.out.println("You can take "+sum+" sum.");
        } else {
            System.err.println("There is not enough money in your card!!!");
        }
    }

    public void unblockCard(Model model){
        if(model.isBlock()){
            model.setBlock(false);
            System.out.println("Card is unblocked!!!");
        } else {
            System.err.println("Card is not blocked!!!");
        }
    }

}
