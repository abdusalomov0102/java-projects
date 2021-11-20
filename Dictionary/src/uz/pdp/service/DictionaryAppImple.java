package uz.pdp.service;

import uz.pdp.model.Result;
import uz.pdp.model.Words;

import java.util.*;

public class DictionaryAppImple implements DictionaryService {

    private Map<String, Words> map = new TreeMap<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public Result addWord() {
        Result result = new Result();

        System.out.print("Enter word : ");
        String key = scanner.nextLine();

        Words words = new Words();
        System.out.print("Translation of word : ");
        words.setTranslate(scanner.nextLine());
        System.out.print("Definition of word : ");
        words.setDefination(scanner.nextLine());

        if (!map.containsKey(key)) {
            ArrayList<String> synonmys = new ArrayList<>();
            System.out.println("Enter synonmys : ");
            String text;
            int i = 1;
            while (true) {
                System.out.print(i + " => ");
                text = scanner.nextLine();
                if (text.trim().length() == 0) {
                    break;
                } else {
                    synonmys.add(text);
                    i++;
                }
            }
            words.setSysnonmy(synonmys);

            ArrayList<String> exmaple = new ArrayList<>();
            System.out.println("Enter examples : ");
            i = 1;
            while (true) {
                System.out.print(i + " => ");
                text = scanner.nextLine();
                if (text.trim().length() == 0) {
                    break;
                } else {
                    exmaple.add(text);
                    i++;
                }
            }
            words.setExample(exmaple);

            map.put(key, words);
            result.setSucces(true);
            result.setMessage("Succesfully added!!!");
        } else {
            result.setMessage(key + " already exists!!!");
        }
        return result;
    }

    @Override
    public Result searchWord() {
        Result result = new Result();

        System.out.print("For search word : ");
        String str = scanner.nextLine();
        Words words = map.get(str);
        if (map.containsKey(str)) {
            System.out.println("\nWord : " + str + " -> " + words.getTranslate());
            System.out.println("Definitions : " + words.getDefination());
            System.out.println("Example : " + words.getExample());
            System.out.println("Synonyms : " + words.getSysnonmy());
        } else {
            System.err.println("There is no word like this!!!");
        }

        return result;
    }

    @Override
    public void editWord() {
        scanner = new Scanner(System.in);
        System.out.print("Enter word : ");
        String str = scanner.nextLine();
        if (map.containsKey(str)) {

            Words words = map.get(str);

            int i = -1;
            while (i != 0) {
                System.out.println("1 :=> Translate                2 :=> Definition\n" +
                        "3 :=> Synonmys                 4 :=> Examples\n                  0 :=> Exit");
                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        scanner = new Scanner(System.in);
                        System.out.print("Enter translate : ");
                        words.setTranslate(scanner.nextLine());
                        System.out.println("Translate succesfully edited !!!");
                        break;
                    case 2:
                        scanner = new Scanner(System.in);
                        System.out.print("Enter definitions : ");
                        words.setDefination(scanner.nextLine());
                        System.out.println("Definition succesfully edited !!!");
                        break;
                    case 3:
                        scanner = new Scanner(System.in);
                        int option = -1;
                        while (option != 0) {
                            System.out.println("0 :=> Exit          1 :=> Add          2 :=> Delete");
                            switch (scanner.nextInt()) {
                                case 0:
                                    break;
                                case 1:
                                    scanner = new Scanner(System.in);
                                    System.out.println("Add new synonmys : ");
                                    words.getSysnonmy().add(scanner.nextLine());
                                    System.out.println("New synonym succesfully added !!!");
                                    break;
                                case 2:
                                    scanner = new Scanner(System.in);
                                    System.out.println("Select number of synonym for delete : ");
                                    for (int j = 0; j < words.getSysnonmy().size(); j++) {
                                        System.out.println((j++) + " :=> " + words.getSysnonmy().get(i));
                                    }
                                    words.getSysnonmy().remove(scanner.nextInt() - 1);
                                    int index = scanner.nextInt();
                                    if (index <= words.getSysnonmy().size()) {
                                        words.getSysnonmy().remove(index - 1);
                                        System.out.println("Synonym deleted succelfully!!!");
                                    } else {
                                        System.err.println("Wrong!!!!!");
                                    }
                                    System.out.println("Synonym succesfully deleted !!!");
                                    break;
                                default:
                                    System.err.println("Wrong options!!!");
                            }
                        }

                        break;
                    case 4:
                        scanner = new Scanner(System.in);

                    default:
                        System.err.println("Wrong options!!!");

                }
            }
        } else {
            System.err.println(str + "Word not founded!!!");
        }

    }

    @Override
    public Map<String, Words> deleteWord() {
        scanner = new Scanner(System.in);
        System.out.print("Which word do you want to delete : ");
        String str = scanner.nextLine();

        if (map.containsKey(str)) {
            map.remove(str);
            System.out.println("Succesfully deleted!!!");
        } else {
            System.err.println("This word is not founded!!\n");
        }
        return map;
    }

    @Override
    public void showWord() {
        Set<Map.Entry<String, Words>> entries = map.entrySet();
        entries.forEach(stringWordsEntry ->
                System.out.println(stringWordsEntry)
        );
    }

}
