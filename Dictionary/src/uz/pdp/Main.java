package uz.pdp;

import uz.pdp.service.DictionaryAppImple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DictionaryAppImple dictionaryAppImple = new DictionaryAppImple();
        System.out.println("+----------------------------------------+\n|------    En -> Uz  Dictionary    ------|" +
                "\n+----------------------------------------+\n");

        while (true) {
            System.out.println("0 => Exit                     1 => Add Word                     2 => Show Words\n" +
                    "3 => Search Words             4 => Delete Words                 5 => Edit Words");
            switch (scanner.nextInt()) {
                case 0:
                    return;
                case 1:
                    dictionaryAppImple.addWord();
                    break;
                case 2:
                    dictionaryAppImple.showWord();
                    break;
                case 3:
                    dictionaryAppImple.searchWord();
                    break;
                case 4:
                    dictionaryAppImple.deleteWord();
                    break;
                case 5:
                    dictionaryAppImple.editWord();
                    break;
                default:
                    System.err.println("Wrong option!!!");
            }
        }

    }
}
