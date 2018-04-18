package org.bootcamp;


import org.bootcamp.calculate.InsurancePolicyCalculator;
import org.bootcamp.formula.BusBasicFormula;
import org.bootcamp.formula.CarBasicFormula;
import org.bootcamp.formula.Formula;
import org.bootcamp.formula.TipperBasicFormula;
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

        final Formula carFormula = new CarBasicFormula();
        final Formula busFormula = new BusBasicFormula();
        final Formula tipperFormula = new TipperBasicFormula();

        int joesPaycheck = calculator.calculate(joesCar, carFormula);
        int stevesPaycheck = calculator.calculate(stevesBus, busFormula);
        int petersPaycheck = calculator.calculate(petersTipper, tipperFormula);

        System.out.println("Joe's policy cost is " + joesPaycheck);
        System.out.println("Steve's policy cost is " + stevesPaycheck);
        System.out.println("Peter's policy cost is " + petersPaycheck);
    }
}
