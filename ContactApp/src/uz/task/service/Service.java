package uz.task.service;

import uz.task.models.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Service {

    ArrayList<Contact> arrayList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void createContact() {
        Contact contact = new Contact(arrayList);
        System.out.println("Contact is created successfully1!");
        arrayList.add(contact);
        sortingServiceByName();
    }

    public boolean searchContact() {
        if (arrayList.size() == 0) {
            System.out.println("No Contacts yet!");
            return false;
        }

        System.out.print("Search (You can search by First Name, Last Name or Phone Number)");
        String search = scanner.nextLine();
        Iterator<Contact> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equals(search) || contact.getLastName().equals(search)
                    || contact.getPhoneNumber().equals(search)) {
                System.out.println(contact);
                return true;
            }
        }
        System.err.println("No result in your contacts?");
        return false;
    }

    public boolean updateContact() {
        if (arrayList.size() == 0) {
            System.out.println("No contacts yet!");
            return false;
        }
        System.out.print("Enter fistName of the Contact: ");
        String name = scanner.nextLine();

        Iterator<Contact> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equals(name)) {
                System.out.println(contact);
                arrayList.remove(contact);
                Contact contactNew = new Contact(arrayList);
                arrayList.add(contactNew);
                sortingServiceByName();
                System.out.println("Contact is updated successfully!");
                return true;
            }
        }
        System.err.println("No results in your contacts!!!");
        return false;
    }

    public boolean deleteContact() {
        if (arrayList.size() == 0) {
            System.out.println("No contact yet!");
            return false;
        }

        System.out.print("Enter First Name of contact: ");
        String name = scanner.nextLine();
        for (Contact contact : arrayList) {
            if (contact.getFirstName().equals(name)) {
                arrayList.remove(contact);
                System.out.println("This contact is deleted successfully!!!");
                return true;
            }
        }
        System.err.println("No results in your Contacts");
        return false;
    }

    public void showContacts() {
        System.out.println("Contact    \n--------------------");
        if (arrayList.size() == 0) {
            System.out.println("No coontact yet!");
        } else {
            for (Contact contact : arrayList) {
                System.out.println(contact.getFirstName());
            }
        }
        System.out.println("--------------------");
    }

    public boolean margeContact() {
        return false;
    }

    public void sortingServiceByName() {
        Collections.sort(arrayList);
    }

}
