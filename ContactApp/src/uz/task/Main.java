package uz.task;

import uz.task.service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
        service.showContacts();

        while (true) {
            System.out.println("0 => Exit                 1 => Create Contact                 2 => Update Contact\n" +
                    "3 => Delete Contact       4 => Show Contact                   5 => Search Contact");
            switch (scanner.nextInt()) {
                case 0:
                    return;
                case 1:
                    service.createContact();
                    break;
                case 2:
                    service.updateContact();
                    break;
                case 3:
                    service.deleteContact();
                    break;
                case 4:
                    service.showContacts();
                    break;
                case 5:
                    service.searchContact();
                    break;
                default:
                    System.err.println("Wrong option!!!");
            }
        }

    }
}
