package org.bootcamp.service;

import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vechicle.Bus;
import org.bootcamp.vechicle.Car;
import org.bootcamp.vechicle.Tipper;
import org.bootcamp.vechicle.Vehicle;

final class ConversionUtils {
    private ConversionUtils() {}

    static Vehicle getVehicle(VehicleInfo vehicleInfo) {
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

    static Formula getFormula(VehicleInfo vehicleInfo) {
        return Formula.valueOf(vehicleInfo.getVehicleTypeFormula());
    }
}
