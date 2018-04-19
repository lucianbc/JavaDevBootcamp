package org.bootcamp.formula;

import org.bootcamp.vechicle.Vehicle;

public enum Formula {

    BUS_BASIC_FORMULA() {
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
    },

    CAR_BASIC_FORMULA() {
        @Override
        public int calculate(Vehicle vehicle) {
            return 100 * vehicle.getAge()
                    + (vehicle.isDiesel() ? 500 : 0)
                    + (vehicle.getNumberOfMiles() > 200000 ? 500 : 0);
        }
    },

    TIPPER_BASIC_FORMULA() {
        @Override
        public int calculate(Vehicle vehicle) {
            return 300 * vehicle.getAge()
                    + (vehicle.getNumberOfMiles() > 80000 ? 700 : 0);
        }
    };

    public abstract int calculate(Vehicle vehicle);
}
