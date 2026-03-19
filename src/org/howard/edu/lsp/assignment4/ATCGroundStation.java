package org.howard.edu.lsp.assignment4;

/**
 * Simulates the ATC ground station that receives and processes aircraft packets.
 */
public class ATCGroundStation {
    private AircraftDatabase aircraftDatabase;

    public ATCGroundStation(AircraftDatabase aircraftDatabase) {
        this.aircraftDatabase = aircraftDatabase;
    }

    /**
     * Receives a packet from an aircraft transponder and processes it.
     */
    public void receivePacket(String packet) {
        // Unpack and parse the packet (simple CSV for this example)
        String[] parts = packet.split(",");
        if (parts.length == 3) {
            String id = parts[0];
            String type = parts[1];
            String flightData = parts[2];
            aircraftDatabase.storeAircraftData(id, type, flightData);
        }
    }
}
