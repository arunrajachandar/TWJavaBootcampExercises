package com.parkingLot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttendantTest {

    @Test
    void parkRegularly() throws ParkingLotFullException {
        Vehicle v1 = new Vehicle(100);
        Vehicle v2 = new Vehicle(102);
        Vehicle v3 = new Vehicle(103);
        ParkingSpace p1 = new ParkingSpace(2);
        p1.parkVehicle(v1);
        ParkingSpace p2 = new ParkingSpace(2);
        p2.parkVehicle(v2);
        List<ParkingSpace> parkingList = new ArrayList<>();
        parkingList.add(p1);
        parkingList.add(p2);
        Attendant a = new Attendant(AttendantType.REGULAR, parkingList);
        assertTrue(p1.equals(a.park(v3)));
    }

    @Test
    void parkSmartly() throws ParkingLotFullException {
        Vehicle v1 = new Vehicle(100);
        Vehicle v2 = new Vehicle(102);
        Vehicle v3 = new Vehicle(103);
        ParkingSpace p1 = new ParkingSpace(3);
        p1.parkVehicle(v1);
        ParkingSpace p2 = new ParkingSpace(2);
        p2.parkVehicle(v2);
        List<ParkingSpace> parkingList = new ArrayList<>();
        parkingList.add(p1);
        parkingList.add(p2);
        Attendant a = new Attendant(AttendantType.SMART, parkingList);
        assertTrue(p2.equals(a.park(v3)));
    }
}
