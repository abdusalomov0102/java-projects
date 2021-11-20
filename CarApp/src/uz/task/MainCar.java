package uz.task;

import java.util.Scanner;

public class MainCar {
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       CarTask carTask =new CarTask();
       while (true) {
           System.out.println("1 => Start Car         2 => Stop Car            3 => Car Drive" +
                              "\n4 => Refill Tank       5 => Car Info            0 => Exit");
           switch (scanner.nextInt()){
               case 0:
                   return;
               case 1:
                   carTask.start();
                   break;
               case 2:
                   carTask.stop();
                   break;
               case 3:
                   carTask.drive();
                   break;
               case 4:
                   carTask.refill();
                   break;
               case 5:
                   carTask.toString();
                   break;
               default:
                   System.err.println("Wrong option!!!");
           }
       }

    }
}
