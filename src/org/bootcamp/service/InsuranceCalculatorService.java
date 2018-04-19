package org.bootcamp.service;

import org.bootcamp.calculate.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleInfoDao;
import org.bootcamp.dao.impl.VehicleInfoPlainFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vechicle.Vehicle;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.bootcamp.service.ConversionUtils.*;

public final class InsuranceCalculatorService {
    private String filePath;

    private static final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

    public InsuranceCalculatorService(String filePath) {
        this.filePath = filePath;
    }

    public List<InsuranceCalculationResult> calculate() {
        VehicleInfoDao vehicleInfoDao = new VehicleInfoPlainFileDao(filePath);

        Collection<VehicleInfo> vehicleInfoCollection = vehicleInfoDao.getAllVehicles();

        if (vehicleInfoCollection.isEmpty()) {
            return Collections.emptyList();
        }

        return vehicleInfoCollection.stream().map(vi -> {
            Vehicle vehicle = getVehicle(vi);
            Formula formula = getFormula(vi);
            int cost = calculator.calculate(vehicle, formula);
            return new InsuranceCalculationResult(vi.getId(), cost);
        }).collect(Collectors.toList());
    }
}
