package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.core.Authenticator;
import pl.camp.it.car.rent.core.Core;
import pl.camp.it.car.rent.model.Motorcycle;
import pl.camp.it.car.rent.model.Writable;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class FileLoader {

    public void readDataFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("db.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] objectData = line.split(";");

                switch (objectData[0]) {
                    case "Motorcycle":
                        Motorcycle motorcycle = new Motorcycle(objectData);
                        break;
                    case "Bus":

                        break;
                    case "Car":

                        break;
                    case "User":

                        break;
                    default:
                        System.out.println("Unexpected type during DB loading");

                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("ZAPSUTE");
        }

    }

    public void saveDataToFile() throws IOException {
        Collection<Writable> entries = new ArrayList<>();
        entries.addAll(Core.getVehicleRepository().getVehicles());
        entries.addAll(Authenticator.getUsersRepository().getUsers());

        BufferedWriter writer = new BufferedWriter(new FileWriter("db.csv"));

        boolean firstTime = true;
        for (Writable entry : entries) {
            String lineInFIle = entry.toCSV();
            if (firstTime) {
                writer.newLine();
                firstTime = false;
            }
            writer.write(lineInFIle);
        }
        writer.close();
    }
}
