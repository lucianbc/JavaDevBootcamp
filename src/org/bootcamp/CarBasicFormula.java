package org.bootcamp;

public class CarBasicFormula implements Formula {
    @Override
    public int calculate(Vehicle vehicle) {
        return 100 * vehicle.getAge()
                + (vehicle.isDiesel() ? 500 : 0)
                + (vehicle.getNumberOfMiles() > 200000 ? 500 : 0);
    }
}
