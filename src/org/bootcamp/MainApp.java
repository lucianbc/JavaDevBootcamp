package org.bootcamp;


import org.bootcamp.calculate.InsurancePolicyCalculator;
import org.bootcamp.formula.Formula;
import org.bootcamp.vechicle.Bus;
import org.bootcamp.vechicle.Car;
import org.bootcamp.vechicle.Tipper;
import org.bootcamp.vechicle.Vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@SuppressWarnings({"squid:S3358", "squid:S106"})
public class MainApp {


    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final int VEHICLE_FORMULA = 2;
    private static final int VEHICLE_ID = 0;

    private static final String SEPARATOR = ";";

    private static final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

    private static final String OUTPUT_FORMAT = "Vechicle with id %s has total cost %d";

    public static void main(String[] args) {

        if (args.length >= 1) {
            final File inputFile = new File(args[0]);
            try (
                    InputStream inputStream = new FileInputStream(inputFile);
                    Scanner scanner = new Scanner(inputStream)
            ) {

                while (scanner.hasNextLine()) {
                    final String line = scanner.nextLine();
                    final String[] tokens = line.split(SEPARATOR);

                    final Vehicle vehicle = getVehicle(
                            tokens[VEHICLE_TYPE],
                            Integer.parseInt(tokens[VEHICLE_AGE]),
                            Long.parseLong(tokens[VEHICLE_MILES]),
                            Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));
                    final Formula formula = Formula.valueOf(tokens[VEHICLE_FORMULA]);

                    final int cost = calculator.calculate(vehicle, formula);

                    final String output = String.format(OUTPUT_FORMAT, tokens[VEHICLE_ID], cost);

                    System.out.println(output);
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("No arguments!");
        }
    }

    private static Vehicle getVehicle(String vehicleName, int age, long numberOfMiles, boolean isDiesel) {
        final String carClassName = Car.class.getSimpleName().toUpperCase();
        final String busClassName = Bus.class.getSimpleName().toUpperCase();
        final String tipperClassName = Tipper.class.getSimpleName().toUpperCase();

        if (vehicleName.equals(carClassName)) {
            return new Car(age, numberOfMiles, isDiesel);
        }
        if (vehicleName.equals(busClassName)) {
            return new Bus(age, numberOfMiles, isDiesel);
        }
        if (vehicleName.equals(tipperClassName)) {
            return new Tipper(age, numberOfMiles, isDiesel);
        }
        return null;
    }
}
