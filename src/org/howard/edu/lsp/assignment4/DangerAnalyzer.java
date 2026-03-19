package org.howard.edu.lsp.assignment4;

import java.util.Map;

/**
 * Analyzes aircraft data for dangerous situations.
 */
public class DangerAnalyzer {
    private AircraftDatabase aircraftDatabase;
    private ControllerInterface controllerInterface;

    public DangerAnalyzer(AircraftDatabase aircraftDatabase, ControllerInterface controllerInterface) {
        this.aircraftDatabase = aircraftDatabase;
        this.controllerInterface = controllerInterface;
    }

    /**
     * Checks for dangerous situations (dummy logic for example).
     */
    public void analyze() {
        for (Map.Entry<String, AircraftDatabase.AircraftRecord> entry : aircraftDatabase.getAllAircraft().entrySet()) {
            AircraftDatabase.AircraftRecord record = entry.getValue();
            // Example: if flightData contains "DANGER", alert controller
            if (record.flightData.contains("DANGER")) {
                controllerInterface.alertDanger(record.id);
            }
        }
    }
}
