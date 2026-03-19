package org.howard.edu.lsp.assignment4;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores and manages aircraft data.
 */
public class AircraftDatabase {
    private Map<String, AircraftRecord> aircraftRecords = new HashMap<>();

    public void storeAircraftData(String id, String type, String flightData) {
        aircraftRecords.put(id, new AircraftRecord(id, type, flightData));
    }

    public AircraftRecord getAircraft(String id) {
        return aircraftRecords.get(id);
    }

    public Map<String, AircraftRecord> getAllAircraft() {
        return aircraftRecords;
    }

    /**
     * Simple record for aircraft data.
     */
    public static class AircraftRecord {
        public String id;
        public String type;
        public String flightData;
        public AircraftRecord(String id, String type, String flightData) {
            this.id = id;
            this.type = type;
            this.flightData = flightData;
        }
    }
}
