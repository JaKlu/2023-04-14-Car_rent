package pl.camp.it.car.rent.core;

import pl.camp.it.car.rent.db.FileLoader;
import pl.camp.it.car.rent.db.VehicleRepository;
import pl.camp.it.car.rent.gui.GUI;

import java.io.IOException;

public class Core {
    private static final VehicleRepository database = new VehicleRepository();

    public static void start() {
        if (!Authenticator.authenticate()) {
            return;
        }
        mainLoop:
        while (true) {
            switch (GUI.showMenu()) {
                case "1":
                    GUI.listVehicles(database.getVehicles());
                    break;
                case "2":
                    GUI.showRentReturnResult(database.rentVehicle(GUI.readPLate()));
                    break;
                case "3":
                    GUI.showRentReturnResult(database.returnVehicle(GUI.readPLate()));
                    break;
                case "4":
                    FileLoader fileLoader = new FileLoader();
                    try {
                        fileLoader.saveDataToFile();
                        break mainLoop;
                    } catch (IOException e) {
                        System.out.println("Database ERROR");
                    }
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }

    public static VehicleRepository getVehicleRepository() {
        return database;
    }
}
