package org.bootcamp;

public final class InsurancePolicyCalculator {

    public static final InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    private InsurancePolicyCalculator() {}

    public int calculate(Car car) {
        return 100 * car.getAge()
                + (car.isDiesel() ? 500 : 0)
                + (car.getNumberOfMiles() > 200000 ? 500 : 0);
    }

    @SuppressWarnings("squid:S3358")
    public int calculate(Bus bus) {
        int paycheck = 200 * bus.getAge() + (bus.isDiesel() ? 1000 : 0);
        if (bus.getNumberOfMiles() > 200000) {
            paycheck += 1000;
        } else if (bus.getNumberOfMiles() > 100000) {
            paycheck += 500;
        }
        return paycheck;
    }

    public int calculate(Tipper tipper) {
        return 300 * tipper.getAge()
                + (tipper.getNumberOfMiles() > 80000 ? 700 : 0);
    }
}
