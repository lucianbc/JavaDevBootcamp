package org.bootcamp;

public class TipperBasicFormula implements Formula {
    @Override
    public int calculate(Vehicle vehicle) {
        return 300 * vehicle.getAge()
                + (vehicle.getNumberOfMiles() > 80000 ? 700 : 0);
    }
}
