package org.bootcamp;


import org.bootcamp.calculate.InsurancePolicyCalculator;
import org.bootcamp.formula.Formula;
import org.bootcamp.vechicle.Bus;
import org.bootcamp.vechicle.Car;
import org.bootcamp.vechicle.Tipper;
import org.bootcamp.vechicle.Vehicle;

@SuppressWarnings({"squid:S3358", "squid:S106"})
public class MainApp {

    public static void main(String[] args) {

        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        final Vehicle joesCar = new Car(5, 200000, true, "auto");
        final Vehicle stevesBus = new Bus(3, 100000, true, 31);
        final Vehicle petersTipper = new Tipper(6, 80000, false, 15);

        int joesPaycheck = calculator.calculate(joesCar, Formula.CAR_BASIC_FORMULA);
        int stevesPaycheck = calculator.calculate(stevesBus, Formula.BUS_BASIC_FORMULA);
        int petersPaycheck = calculator.calculate(petersTipper, Formula.TIPPER_BASIC_FORMULA);

        System.out.println("Joe's policy cost is " + joesPaycheck);
        System.out.println("Steve's policy cost is " + stevesPaycheck);
        System.out.println("Peter's policy cost is " + petersPaycheck);
    }
}
