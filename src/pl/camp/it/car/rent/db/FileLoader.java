package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FileLoader {
    private static final FileLoader instance = new FileLoader();
    private final VehicleRepository vehicleRepository = VehicleRepository.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();

    private FileLoader() {
    }

    public void readDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("db.csv"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] objectData = line.split(";");
            String[] vars = Arrays.copyOfRange(objectData, 1, objectData.length);

            switch (objectData[0]) {
                case "Motorcycle":
                    Motorcycle motorcycle = new Motorcycle(vars);
                    vehicleRepository.addVehicle(motorcycle);
                    break;
                case "Bus":
                    Bus bus = new Bus(vars);
                    vehicleRepository.addVehicle(bus);
                    break;
                case "Car":
                    Car car = new Car(vars);
                    vehicleRepository.addVehicle(car);
                    break;
                case "User":
                    User user = new User(vars);
                    userRepository.addUser(user);
                    break;
                default:
                    System.out.println("Unexpected type during DB loading");
                    break;
            }
        }
        reader.close();
    }

    public void saveDataToFile() throws IOException {
        Collection<Writable> entries = new ArrayList<>();
        entries.addAll(vehicleRepository.getVehicles());
        entries.addAll(userRepository.getUsers());

        BufferedWriter writer = new BufferedWriter(new FileWriter("db.csv"));

        boolean firstTime = true;
        for (Writable entry : entries) {
            String lineInFIle = entry.toCSV();
            if (!firstTime) {
                writer.newLine();
            }
            firstTime = false;
            writer.write(lineInFIle);
        }
        writer.close();
    }

    public static FileLoader getInstance() {
        return instance;
    }
}
