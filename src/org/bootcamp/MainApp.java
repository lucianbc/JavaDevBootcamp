package org.bootcamp;


import org.bootcamp.service.InsuranceCalculationResult;
import org.bootcamp.service.InsuranceCalculatorService;

import java.util.List;

@SuppressWarnings({"squid:S106"})
public class MainApp {


    private static final String OUTPUT_FORMAT = "Vechicle with id %s has total cost %d";

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("No arguments!");
            return;
        }

        final InsuranceCalculatorService insuranceCalculatorService = new InsuranceCalculatorService(args[0]);

        final List<InsuranceCalculationResult> results = insuranceCalculatorService.calculate();

        if (results.isEmpty()) {
            System.out.println("No records!");
        }

        for (InsuranceCalculationResult r : results) {
            System.out.println(String.format(OUTPUT_FORMAT, r.getId(), r.getCost()));
        }
    }
}
