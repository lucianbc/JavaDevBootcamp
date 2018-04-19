package org.bootcamp.dao.impl;

import org.bootcamp.dao.VehicleInfoDao;
import org.bootcamp.model.VehicleInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"squid:S106"})
public class VehicleInfoPlainFileDao implements VehicleInfoDao {

    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final int VEHICLE_FORMULA = 2;
    private static final int VEHICLE_ID = 0;

    private static final String SEPARATOR = ";";

    private final String filePath;

    public VehicleInfoPlainFileDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<VehicleInfo> getAllVehicles() {
        final File inputFile = new File(filePath);
        List<VehicleInfo> vehicleInfoList = new LinkedList<>();
        try (
                InputStream inputStream = new FileInputStream(inputFile);
                Scanner scanner = new Scanner(inputStream)
        ) {

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                final String[] tokens = line.split(SEPARATOR);

                final VehicleInfo vehicleInfo = new VehicleInfo(
                        tokens[VEHICLE_ID],
                        tokens[VEHICLE_TYPE],
                        tokens[VEHICLE_FORMULA],
                        Integer.parseInt(tokens[VEHICLE_AGE]),
                        Long.parseLong(tokens[VEHICLE_MILES]),
                        Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL])
                );

                vehicleInfoList.add(vehicleInfo);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return vehicleInfoList;
    }
}
