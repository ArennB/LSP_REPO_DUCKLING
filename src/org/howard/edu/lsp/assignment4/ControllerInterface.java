package org.howard.edu.lsp.assignment4;

/**
 * Interface for the ATC controller to interact with the system.
 */
public class ControllerInterface {
    private AircraftDatabase aircraftDatabase;

    public ControllerInterface(AircraftDatabase aircraftDatabase) {
        this.aircraftDatabase = aircraftDatabase;
    }

    /**
     * Query details about a specific aircraft.
     */
    public void queryAircraft(String id) {
        AircraftDatabase.AircraftRecord record = aircraftDatabase.getAircraft(id);
        if (record != null) {
            System.out.println("Query Result: Aircraft ID: " + record.id + ", Type: " + record.type + ", Data: " + record.flightData);
        } else {
            System.out.println("Aircraft not found.");
        }
    }

    /**
     * Display an alert to the controller.
     */
    public void alertDanger(String aircraftId) {
        System.out.println("ALERT: Dangerous situation detected for Aircraft ID: " + aircraftId);
    }
}
