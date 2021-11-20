package uz.task;

import java.util.Scanner;

public class CarTask {

    private String model;
    private String number;
    private String color;
    private double petrolShow;
    private double petrolUse; //for 100km
    private double petrolTank;
    private double petrolPrice = 3000;
    private boolean status;

    public CarTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Model : ");
        model = scanner.nextLine();
        System.out.print("Number of car : ");
        number = scanner.nextLine();
        System.out.print("Color of car : ");
        color = scanner.nextLine();
        System.out.print("Petrol tank = ");
        petrolTank = scanner.nextInt();
        System.out.print("Petrol use for 100km = ");
        petrolUse = scanner.nextInt();
        System.out.print("Petrol just in tank = ");
        petrolShow = scanner.nextInt();
        status = true;
    }

    public void start(){
        if (status){
            System.err.println("Car is already started!!!");
        } else {
            status = true;
            System.out.println("Car is started!");
            if (petrolShow < 5){
                System.err.println("You have "+petrolShow+ " litre petrol. \n" +
                        "Please refill.");
            }
        }
    }

    public void stop(){
        if (status){
            status= false;
            System.out.println("Car is stopped!!");
        } else {
            System.out.println("Car is already off!!!");
        }
    }

    public void drive(){
        if (status){
            if (petrolShow>0){
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter distance(km) = ");
                int distance = scanner.nextInt();
                if (distance*petrolUse/100 < petrolShow){
                    petrolShow -=distance*petrolUse/100;
                    System.out.println(distance+" km is drove.");
                    if (petrolShow<5){
                        System.err.println("You have "+petrolShow+ " litre petrol.");
                    }
                } else {
                    System.out.println(petrolShow*100/petrolUse+" km is drove.");
                    petrolShow=0;
                    System.out.println("Please, refill.");
                }
            } else {
                System.err.println("Petrol Tank is free. \nPlease, refill.");
            }
        } else {
            System.err.println("Car is off!!!");
        }
    }

    public void refill(){
        Scanner scanner=new Scanner(System.in);
        double possiblePetrol = petrolTank-petrolShow;
        System.out.println("Which kind of service do you want!!!");
        System.out.println("0 => Back          1 => By litre          " +
                "2 => By Money          3 => Full Bag");
        switch (scanner.nextInt()){
            case 0:
                break;
            case 1:
                System.out.println("Enter amount of petrol : ");
                double petrol = scanner.nextDouble();
                if (petrol<possiblePetrol){
                    petrolShow+=petrol;
                    System.out.println(petrol+" litre is infused! You must to pay "+ petrolPrice*petrol +" sum.");
                } else {
                    petrolShow=petrolTank;
                    System.out.println("Petrol Tank is filled.");
                    System.out.println(possiblePetrol+" litre is infused. You must to pay "+possiblePetrol*petrolPrice+" sum.");
                }
                break;
            case 2:
                System.out.println("Enter amout sum (1 litre 3000 sum): ");
                double sum = scanner.nextDouble();
                if (sum<possiblePetrol*petrolPrice){
                    petrolShow+=sum/petrolPrice;
                    System.out.println(sum/petrolPrice+" litre is infused! You must to pay "+ sum +" sum.");
                } else {
                    petrolShow=petrolTank;
                    System.out.println("Petrol Tank is filled.");
                    System.out.println(sum/petrolPrice + " litre is infused! You must to pay "+possiblePetrol*petrolPrice+" sum");
                }
                break;
            case 3:
                petrolShow=petrolTank;
                System.out.println("Petrol Tank is filled. ");
                System.out.println(possiblePetrol+ " litre is infused. You must to pay "+possiblePetrol*petrolPrice+" sum.");
                break;
            default:
                System.err.println("Wrong optiona!!!");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                ", petrolShow=" + petrolShow +
                ", petrolUse=" + petrolUse +
                ", petrolTank=" + petrolTank +
                ", petrolPrice=" + petrolPrice +
                ", status=" + status +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPetrolShow() {
        return petrolShow;
    }

    public void setPetrolShow(double petrolShow) {
        this.petrolShow = petrolShow;
    }

    public double getPetrolUse() {
        return petrolUse;
    }

    public void setPetrolUse(double petrolUse) {
        this.petrolUse = petrolUse;
    }

    public double getPetrolTank() {
        return petrolTank;
    }

    public void setPetrolTank(double petrolTank) {
        this.petrolTank = petrolTank;
    }

    public double getPetrolPrice() {
        return petrolPrice;
    }

    public void setPetrolPrice(double petrolPrice) {
        this.petrolPrice = petrolPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}