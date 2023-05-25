import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
interface Booking {
    void book();
}
class CoffeeShop {
    private String name;
    private String location;
 public CoffeeShop(String name, String location) {
        this.name = name;
        this.location = location;
    }
    public void displayInfo() {
        System.out.println("Coffee Shop: " + name);
        System.out.println("Location: " + location);
    }
}
class Star extends CoffeeShop {
    private int numberOfOutlets;
    public Star(String name, String location, int numberOfOutlets) {
        super(name, location);
        this.numberOfOutlets = numberOfOutlets;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Outlets: " + numberOfOutlets);
    }
}
class Coffee {
    private String name;
    private double price;
    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void displayInfo() {
        System.out.println("Coffee: " + name);
        System.out.println("Price: $" + price);
    }
}
class Cappuccino extends Coffee {
    private String size;
    public Cappuccino(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Size: " + size);
    }
}
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}
class OnlineBooking implements Booking {
    private String customerName;
    private CoffeeShop coffeeShop;
    private List<Coffee> coffeeList;
    private String location;
    private double totalCost;
    public OnlineBooking(String customerName, CoffeeShop coffeeShop, String location) {
        this.customerName = customerName;
        this.coffeeShop = coffeeShop;
        this.location = location;
        coffeeList = new ArrayList<>();
    }
    public void addCoffee(Coffee coffee) {
        coffeeList.add(coffee);
        totalCost += coffee.getPrice();
    }
    public void book() {
        try {
            validateBooking();
            displayBookingDetails();
            askForApproval();
        } catch (Exception e) {
            System.out.println("Invalid Booking: " + e.getMessage());
        }
    }
    private void validateBooking() throws InvalidBookingException {
        if (coffeeList.isEmpty()) {
            throw new InvalidBookingException("No coffees selected");
        }
    }
    private void displayBookingDetails() {
        System.out.println("Booking Details");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Location: " + location);
        coffeeShop.displayInfo();
        for (Coffee coffee : coffeeList) {
            coffee.displayInfo();
        }
        System.out.println("Total Cost: $" + totalCost);
    }

    private void askForApproval() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to approve your order? (yes/no): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Thank you for choosing our coffee shop!");
            generateDiscount();
        } else {
            System.out.println("Your order has been canceled.");
        }
    }

    private void generateDiscount() {
        Random random = new Random();
        int discount = random.nextInt(11); // Generate random discount between 0 and 10
        System.out.println("Congratulations! You've received a " + discount + "% discount on your next order.");
    }
}
public class CoffeeBookingSystem {
    public static void main(String[] args) {
        try {
            File f = new File("filename. txt");
            if (f.createNewFile()) {
            System.out.println("File created: " + f. getName ());
            } else {
            System.out.println("File already exists.");
            }
            } catch (IOException e) {
            System.out.println("An error occurred."); e.printStackTrace();
            }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Coffee Shop");
        System.out.println("Sign up");// Sign up
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Confirm Password: ");
        String confirmPassword = scanner.nextLine();
        System.out.print("Location: ");
        String location = scanner.nextLine();
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Sign up failed.");
            return;
        }
        System.out.println("\nSign in");// Sign in
        System.out.print("Email: ");
        String signInEmail = scanner.nextLine();
        System.out.print("Password: ");
        String signInPassword = scanner.nextLine();

        if (!signInEmail.equals(email) || !signInPassword.equals(password)) {
            System.out.println("Invalid email or password. Sign in failed.");
            return;
        }
        Star star = new Star("Coffee Shop", "123 Main St", 2);
        Coffee americano = new Coffee("Americano", 8.99);
        Coffee spanishLatte = new Coffee("Spanish Latte", 2.49);
        Coffee pistachioLatte = new Coffee("Pistachio Latte", 9.99);
        Coffee espresso = new Coffee("Espresso", 2.99);
        Coffee CaramelLatte = new Coffee("Caramel Latte", 3.99);
        Coffee Cappuccino = new Coffee("Cappuccino", 5.99);
        System.out.println("\nCoffee Menu");
        System.out.println("1. " + americano.getName() + " - $" + americano.getPrice());
        System.out.println("2. " + spanishLatte.getName() + " - $" + spanishLatte.getPrice());
        System.out.println("3. " + pistachioLatte.getName() + " - $" + pistachioLatte.getPrice());
        System.out.println("4. " + espresso.getName() + " - $" + espresso.getPrice());
        System.out.println("5. " + CaramelLatte.getName() + " - $" + CaramelLatte.getPrice());
        System.out.println("6. " + Cappuccino.getName() + " - $" + Cappuccino.getPrice());
        
        List<Coffee> selectedCoffees = new ArrayList<>();
        System.out.print("\nEnter the number of cups you want to order: ");
        int numCups = scanner.nextInt();
        for (int i = 0; i < numCups; i++) {
            System.out.print("Choose a coffee (1-5): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    selectedCoffees.add(americano);
                    break;
                case 2:
                    selectedCoffees.add(spanishLatte);
                    break;
                case 3:
                    selectedCoffees.add(pistachioLatte);
                    break;
                case 4:
                    selectedCoffees.add(espresso);
                    break;
                case 5:
                    selectedCoffees.add(CaramelLatte);
                    break;
                    case 6:
                    selectedCoffees.add(Cappuccino);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    i--;
                    break;
            }
        }
        OnlineBooking onlineBooking = new OnlineBooking(firstName + " " + lastName, star, location);
        for (Coffee coffee : selectedCoffees) {
            onlineBooking.addCoffee(coffee);
        }
        onlineBooking.book();
    }
}