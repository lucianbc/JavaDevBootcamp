package org.bootcamp.model;

public class VehicleInfo {
    private String id;
    private String vehicleTypeName;
    private String vehicleTypeFormula;
    private int age;
    private long numberOfMiles;
    private boolean isDiesel;

    public VehicleInfo() {
    }

    public VehicleInfo(String id, String vehicleTypeName, String vehicleTypeFormula, int age, long numberOfMiles, boolean isDiesel) {
        this.id = id;
        this.vehicleTypeName = vehicleTypeName;
        this.vehicleTypeFormula = vehicleTypeFormula;
        this.age = age;
        this.numberOfMiles = numberOfMiles;
        this.isDiesel = isDiesel;
    }

    public String getId() {
        return id;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public String getVehicleTypeFormula() {
        return vehicleTypeFormula;
    }

    public int getAge() {
        return age;
    }

    public long getNumberOfMiles() {
        return numberOfMiles;
    }

    public boolean isDiesel() {
        return isDiesel;
    }
}
