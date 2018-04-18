package org.bootcamp.vechicle;

public final class Car extends Vehicle {
    private String transmission = "manual";

    protected Car() {}

    protected Car(int age, long numberOfMiles, boolean isDiesel, String transmission) {
        super(age, numberOfMiles, isDiesel);
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
