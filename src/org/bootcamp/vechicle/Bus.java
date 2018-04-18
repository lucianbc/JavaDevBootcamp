package org.bootcamp.vechicle;

public final class Bus extends Vehicle {

    private int numberOfSeats = 0;

    public Bus(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Bus(int age, long numberOfMiles, boolean isDiesel, int numberOfSeats) {
        super(age, numberOfMiles, isDiesel);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
