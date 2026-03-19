package org.howard.edu.lsp.assignment4;

/**
 * Main class to demonstrate the ATC system.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AircraftDatabase aircraftDatabase = new AircraftDatabase();
        ControllerInterface controllerInterface = new ControllerInterface(aircraftDatabase);
        ATCGroundStation atcGroundStation = new ATCGroundStation(aircraftDatabase);
        DisplaySystem displaySystem = new DisplaySystem(aircraftDatabase);
        DangerAnalyzer dangerAnalyzer = new DangerAnalyzer(aircraftDatabase, controllerInterface);

        // Simulate aircraft arrivals
        AircraftTransponder transponder1 = new AircraftTransponder("A100", "Boeing737", "ALT:3000;SPD:250");
        AircraftTransponder transponder2 = new AircraftTransponder("A200", "AirbusA320", "ALT:3200;SPD:240;DANGER:TCAS");
        AircraftTransponder transponder3 = new AircraftTransponder("A300", "Cessna172", "ALT:1500;SPD:120");

        // Ground station receives packets
        atcGroundStation.receivePacket(transponder1.broadcastPacket());
        atcGroundStation.receivePacket(transponder2.broadcastPacket());
        atcGroundStation.receivePacket(transponder3.broadcastPacket());

        // Display update and danger analysis loop (simulate one cycle)
        displaySystem.updateDisplay();
        dangerAnalyzer.analyze();

        // Controller queries
        controllerInterface.queryAircraft("A200");
        controllerInterface.queryAircraft("A999"); // Not found
    }
}
