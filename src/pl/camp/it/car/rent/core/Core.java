package pl.camp.it.car.rent.core;

import pl.camp.it.car.rent.db.FileLoader;
import pl.camp.it.car.rent.db.VehicleRepository;
import pl.camp.it.car.rent.gui.GUI;

import java.io.IOException;

public class Core {
    private static final Core instance = new Core();
    private final GUI gui = GUI.getInstance();
    private final VehicleRepository vehicleRepository = VehicleRepository.getInstance();
    private final FileLoader fileLoader = FileLoader.getInstance();

    private Core() {
    }

    public void start() {
        try {
            fileLoader.readDataFromFile();
        } catch (IOException e) {
            System.out.println("Error while reading from database");
            return;
        }
        if (!Authenticator.getInstance().authenticate()) {
            return;
        }
        mainLoop:
        while (true) {
            switch (gui.showMenu()) {
                case "1":
                    gui.listVehicles();
                    break;
                case "2":
                    gui.showRentReturnResult(vehicleRepository.rentVehicle(gui.readPLate()));
                    break;
                case "3":
                    gui.showRentReturnResult(vehicleRepository.returnVehicle(gui.readPLate()));
                    break;
                case "4":
                    try {
                        fileLoader.saveDataToFile();
                        break mainLoop;
                    } catch (IOException e) {
                        System.out.println("Error while writing to database");
                    }
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }

    public static Core getInstance() {
        return instance;
    }
}
