# CRC Cards

## Class: AircraftTransponder
**Responsibilities:**
- Broadcast aircraft type and flight data
**Collaborators:**
- ATCGroundStation
**Assumptions:**
- Each aircraft has a unique transponder
- Data format is standardized

---

## Class: ATCGroundStation
**Responsibilities:**
- Receive transponder packets
- Unpack and parse flight data
- Store aircraft data in AircraftDatabase
**Collaborators:**
- AircraftDatabase
**Assumptions:**
- Ground station is always online
- Can process multiple packets simultaneously

---

## Class: AircraftDatabase
**Responsibilities:**
- Store aircraft and flight data
- Provide data for queries
- Provide data for display updates
**Collaborators:**
- None
**Assumptions:**
- Data is updated in real time
- Supports efficient queries

---

## Class: DisplaySystem
**Responsibilities:**
- Build and update graphics display every 10 seconds
- Retrieve aircraft data for display
**Collaborators:**
- AircraftDatabase
**Assumptions:**
- Display refreshes automatically
- All aircraft data is available

---

## Class: DangerAnalyzer
**Responsibilities:**
- Analyze aircraft data for dangerous situations
- Alert controller if danger detected
**Collaborators:**
- AircraftDatabase
- ControllerInterface
**Assumptions:**
- Danger criteria are well-defined
- Analysis runs continuously

---

## Class: ControllerInterface
**Responsibilities:**
- Allow controller to query aircraft details
- Display alerts and information to controller
**Collaborators:**
- DangerAnalyzer
**Assumptions:**
- Controller can access all current data
- Interface is user-friendly
