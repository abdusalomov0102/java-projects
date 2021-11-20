package uz.java;

import uz.java.model.ModelCard;
import uz.java.service.ServicesCard;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ModelCard modelCard = new ModelCard();
        ServicesCard servicesCard = new ServicesCard();

        while (true) {
            System.out.println("1 => Bankomat      2 => Terminal       3 => Unblock the card" +
                             "\n4 => Card info     5 => Enter money    0 => Exit");
            switch (scanner.nextInt()) {
                case 0:
                    return;
                case 1:
                    servicesCard.Bankomat(modelCard);
                    break;
                case 2:
                    servicesCard.Terminal(modelCard);
                    break;
                case 3:
                    servicesCard.unblockCard(modelCard);
                    break;
                case 4:
                    System.out.println(modelCard);
                    break;
                case 5:
                    System.out.print("Enter money : ");
                    double sum = scanner.nextDouble();
                    modelCard.setBalance(modelCard.getBalance() + sum);
                    System.out.println(sum + " so'm is entered to the card succesfully!!!");
                    break;
                default:
                    System.err.println("Wrong chance!!!");

            }
        }

    }
}
