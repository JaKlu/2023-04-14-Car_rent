package pl.camp.it.car.rent.gui;

import pl.camp.it.car.rent.model.User;
import pl.camp.it.car.rent.model.Vehicle;

import java.util.Collection;
import java.util.Scanner;

public class GUI {
    private static final GUI instance = new GUI();
    private static Scanner scanner = new Scanner(System.in);

    private GUI() {
    }

    public String showMenu() {
        System.out.println("1. List vehicles");
        System.out.println("2. Rent vehicles");
        System.out.println("3. Return vehicles");
        System.out.println("4. Exit");

        return scanner.nextLine();
    }

    public void listVehicles(Collection<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public String readPLate() {
        System.out.println("Insert plate number: ");
        return scanner.nextLine();
    }

    public void showRentReturnResult(boolean result) {
        if (result) {
            System.out.println("Success!");
        } else {
            System.out.println("Error!");
        }
    }

    public User readLoginAndPassword() {
        System.out.println("Login:");
        String login = scanner.nextLine();

        System.out.println("Password:");
        return new User(login, scanner.nextLine());
    }

    public static GUI getInstance() {
        return instance;
    }
}
