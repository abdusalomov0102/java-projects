package uz.task.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact implements Comparable<Contact> {

    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private String notes;

    Scanner scanner = new Scanner(System.in);

    @Override
    public int compareTo(Contact o) {
        return this.firstName.compareTo(o.getFirstName());
    }

    public Contact(ArrayList<Contact> arrayList) {
        System.out.print("First Name : ");
        firstName = scanner.nextLine();
        arrayList.forEach(contact -> {
            if (contact.getFirstName().equals(firstName)) {
                System.err.println("This contact created before!!!");
                System.out.print("Firt Name : ");
                firstName = scanner.nextLine();
            }
        });
        System.out.print("Last Name : ");
        lastName = scanner.nextLine();
        System.out.print("Company : ");
        company = scanner.nextLine();
        System.out.print("Job Title : ");
        jobTitle = scanner.nextLine();
        System.out.print("Email : ");
        email = scanner.nextLine();
        System.out.print("Phone Number : ");
        phoneNumber = scanner.nextLine();
        System.out.print("For notes : ");
        notes = scanner.nextLine();
    }

    public Contact(String firstName, String lastName, String company, String jobTitle, String email, String phoneNumber, String notes, Scanner scanner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.scanner = scanner;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", notes='" + notes + '\'' +
                ", scanner=" + scanner +
                '}';
    }


}
