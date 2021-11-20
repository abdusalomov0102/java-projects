package uz.car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        while (true) {
            System.out.println("1 => Start Car             2 => Stop Car             3 => Car Drive\n" +
                    "4 => Refill Tank           5 => Car Info             0 => Exit");
            switch (scanner.nextByte()) {
                case 0:
                    return;
                case 1:
                    car.start();
                    break;
                case 2:
                    car.stop();
                    break;
                case 3:
                    car.drive();
                    break;
                case 4:
                    car.refill();
                    break;
                case 5:
                    System.out.println(car.toString());
                    break;
                default:
                    System.err.println("Wrong option!!!");
            }
        }

    }
}
