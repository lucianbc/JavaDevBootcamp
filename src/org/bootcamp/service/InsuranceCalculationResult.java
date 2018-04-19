package org.bootcamp.service;

public class InsuranceCalculationResult {
    private String id;
    private int cost;

    InsuranceCalculationResult(String id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }
}
