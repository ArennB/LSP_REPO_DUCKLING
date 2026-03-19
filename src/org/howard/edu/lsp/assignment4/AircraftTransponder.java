package org.howard.edu.lsp.assignment4;

/**
 * Simulates an aircraft's transponder broadcasting flight data.
 */
public class AircraftTransponder {
    private String id;
    private String type;
    private String flightData;

    public AircraftTransponder(String id, String type, String flightData) {
        this.id = id;
        this.type = type;
        this.flightData = flightData;
    }

    /**
     * Broadcasts the aircraft's data as a packet.
     */
    public String broadcastPacket() {
        // Simulate high-density packet format
        return id + "," + type + "," + flightData;
    }

    // Getters
    public String getId() { return id; }
    public String getType() { return type; }
    public String getFlightData() { return flightData; }
}
