package com.parkingLot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Attendant {
    private AttendantType attendantType;
    private List<ParkingSpace> lots;
    public Attendant(AttendantType attendantType, List<ParkingSpace> ps) {
        this.attendantType = attendantType;
        this.lots = ps;
    }

    public ParkingSpace park(Vehicle vehicle) throws ParkingLotFullException {
        try {
            Optional<ParkingSpace> foundParking;
            if(attendantType == AttendantType.SMART) {
                foundParking = lots.stream().min(Comparator.comparingInt(ParkingSpace::getFreeSpace));
            } else { foundParking = Optional.of(lots.stream().filter(p -> !p.isSpaceFull()).findFirst().get()); }
            foundParking.get().parkVehicle(vehicle);
            foundParking.get().toString();
            return foundParking.get();
        } catch (ParkingLotFullException e) {
            throw new ParkingLotFullException("Parking is not found");
        }
    }

}
