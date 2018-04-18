package org.bootcamp;


@SuppressWarnings({"squid:S3358", "squid:S106"})
public class MainApp {

    public static void main(String[] args) {
        InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        final Car joesCar = new Car(5, 200000, true, "auto");
        final Bus stevesBus = new Bus(3, 100000, true, 31);
        final Tipper petersTipper = new Tipper(6, 80000, false, 15);

        final int joesPaycheck = calculator.calculate(joesCar);

        final int stevesPaycheck = calculator.calculate(stevesBus);

        final int petersPaycheck = calculator.calculate(petersTipper);

        System.out.println("Joe's policy cost is " + joesPaycheck);
        System.out.println("Steve's policy cost is " + stevesPaycheck);
        System.out.println("Peter's policy cost is " + petersPaycheck);
    }
}
