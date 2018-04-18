package org.bootcamp;

public class BusBasicFormula implements Formula {
    @Override
    public int calculate(Vehicle vehicle) {
        int paycheck = 200 * vehicle.getAge() + (vehicle.isDiesel() ? 1000 : 0);
        if (vehicle.getNumberOfMiles() > 200000) {
            paycheck += 1000;
        } else if (vehicle.getNumberOfMiles() > 100000) {
            paycheck += 500;
        }
        return paycheck;
    }
}
