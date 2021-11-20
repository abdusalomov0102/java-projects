package uz.task;

import uz.task.model.Model;
import uz.task.service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Model model = new Model();
        Service service = new Service();

        while (true){
            System.out.println("1 => Bankomat             2 => Terminal               3 => Unblock the Card" +
                               "\n4 => Card Info            5 => Enter Money            0 => Exit");
            switch (scanner.nextInt()){
                case 0:
                    return;
                case 1:
                    service.Bankomat(model);
                    break;
                case 2:
                    service.Terminal(model);
                    break;
                case 3:
                    service.unblockCard(model);
                    break;
                case 4:
                    System.out.println(model);
                    break;
                case 5:
                    System.out.print("Enter money: ");
                    double sum = scanner.nextDouble();
                    model.setBalance(model.getBalance()+sum);
                    System.out.println(sum+" sum is entered to the card succesfully.");
                    break;
                default:
                    System.err.println("Wrong options!!!");
            }
        }

    }
}
