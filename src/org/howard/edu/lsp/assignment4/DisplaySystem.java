package org.howard.edu.lsp.assignment4;

import java.util.Map;

/**
 * Handles the graphics display for the ATC system.
 */
public class DisplaySystem {
    private AircraftDatabase aircraftDatabase;

    public DisplaySystem(AircraftDatabase aircraftDatabase) {
        this.aircraftDatabase = aircraftDatabase;
    }

    /**
     * Updates the display with current aircraft data.
     */
    public void updateDisplay() {
        System.out.println("--- ATC Display Update ---");
        for (Map.Entry<String, AircraftDatabase.AircraftRecord> entry : aircraftDatabase.getAllAircraft().entrySet()) {
            AircraftDatabase.AircraftRecord record = entry.getValue();
            System.out.println("Aircraft ID: " + record.id + ", Type: " + record.type + ", Data: " + record.flightData);
        }
        System.out.println("--------------------------");
    }
}
