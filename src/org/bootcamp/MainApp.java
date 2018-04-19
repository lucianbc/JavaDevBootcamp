package org.bootcamp;


import org.bootcamp.calculate.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleInfoDao;
import org.bootcamp.dao.impl.VehicleInfoPlainFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vechicle.Bus;
import org.bootcamp.vechicle.Car;
import org.bootcamp.vechicle.Tipper;
import org.bootcamp.vechicle.Vehicle;

import java.util.Collection;

@SuppressWarnings({"squid:S106"})
public class MainApp {

    private static final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

    private static final String OUTPUT_FORMAT = "Vechicle with id %s has total cost %d";

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("No arguments!");
            return;
        }

        VehicleInfoDao vehicleInfoDao = new VehicleInfoPlainFileDao(args[0]);

        Collection<VehicleInfo> vehicleInfoCollection = vehicleInfoDao.getAllVehicles();

        if (vehicleInfoCollection.isEmpty()) {
            System.err.println("No records found");
            return;
        }

        for (VehicleInfo vi : vehicleInfoCollection) {
            Vehicle vehicle = getVehicle(vi);
            Formula formula = getFormula(vi);
            int cost = calculator.calculate(vehicle, formula);
            String output = String.format(OUTPUT_FORMAT, vi.getId(), cost);
            System.out.println(output);
        }
    }

    private static Vehicle getVehicle(VehicleInfo vehicleInfo) {
        return getVehicle(vehicleInfo.getVehicleTypeName(), vehicleInfo.getAge(), vehicleInfo.getNumberOfMiles(), vehicleInfo.isDiesel());
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

    private static Formula getFormula(VehicleInfo vehicleInfo) {
        return Formula.valueOf(vehicleInfo.getVehicleTypeFormula());
    }
}
