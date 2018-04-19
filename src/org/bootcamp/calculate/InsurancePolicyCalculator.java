package org.bootcamp.calculate;

import org.bootcamp.formula.FormulaEnum;
import org.bootcamp.vechicle.Vehicle;

public final class InsurancePolicyCalculator {

    public static final InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    private InsurancePolicyCalculator() {}

    public int calculate(Vehicle vehicle, FormulaEnum formula) {
        return formula.calculate(vehicle);
    }
}
