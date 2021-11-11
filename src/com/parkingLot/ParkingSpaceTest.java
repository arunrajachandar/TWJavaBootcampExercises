package com.parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingSpaceTest {

    @Test
    void returnTrueIfVehicleIsParked() throws ParkingLotFullException {
        Vehicle v1 = new Vehicle(100);
        ParkingSpace ps = new ParkingSpace(2);
        ps.parkVehicle(v1);
        Assertions.assertEquals(1, ps.getParkedSpaces());
    }

    @Test
    void returnTrueIfVehicleIsRemoved() throws ParkingLotFullException {
        Vehicle v1 = new Vehicle(100);
        ParkingSpace ps = new ParkingSpace(2);
        ps.parkVehicle(v1);
        ps.unParkVehicle(100);
        Assertions.assertEquals(0, ps.getParkedSpaces());
    }

    @Test
    void returnExceptionIfParkingIsFull() throws ParkingLotFullException {
        Vehicle v1 = new Vehicle(100);
        Vehicle v2 = new Vehicle(102);
        Vehicle v3 = new Vehicle(103);
        ParkingSpace ps = new ParkingSpace(2);
        Assertions.assertThrows(ParkingLotFullException.class, () -> {
            ps.parkVehicle(v1);
            ps.parkVehicle(v2);
            ps.parkVehicle(v3);
        }, "Parking is Full");
    }

    @Test
    void notifyWhenParkingIsFull() throws ParkingLotFullException {
        List<ParkingLotObserver> plos = new ArrayList<>();
        plos.add(ParkingLotObserver.owner());
        plos.add(ParkingLotObserver.attendant());
        ParkingSpace ps = new ParkingSpace(3, plos);
        Vehicle v1 = new Vehicle(100);
        Vehicle v2 = new Vehicle(102);
        Vehicle v3 = new Vehicle(103);
        ps.parkVehicle(v1);
        ps.parkVehicle(v2);
        ps.parkVehicle(v3);
        assertTrue(plos.stream().allMatch(p -> p.getParkingLotStatus() == ParkingLotStatus.RED));
    }

    @Test
    void notifyWhenParkingIsAvailable() throws ParkingLotFullException {
        List<ParkingLotObserver> plos = new ArrayList<>();
        plos.add(ParkingLotObserver.owner());
        plos.add(ParkingLotObserver.attendant());
        ParkingSpace ps = new ParkingSpace(3, plos);
        Vehicle v1 = new Vehicle(100);
        Vehicle v2 = new Vehicle(102);
        Vehicle v3 = new Vehicle(103);
        ps.parkVehicle(v1);
        ps.parkVehicle(v2);
        ps.parkVehicle(v3);
        ps.unParkVehicle(103);
        assertTrue(plos.stream().allMatch(p -> p.getParkingLotStatus() == ParkingLotStatus.GREEN));
    }
}
