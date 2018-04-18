package org.bootcamp.formula;

import org.bootcamp.vechicle.Vehicle;

public class CarBasicFormula implements Formula {
    @Override
    public int calculate(Vehicle vehicle) {
        return 100 * vehicle.getAge()
                + (vehicle.isDiesel() ? 500 : 0)
                + (vehicle.getNumberOfMiles() > 200000 ? 500 : 0);
    }
}
