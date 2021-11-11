package com.parkingLot;

public class ParkingLotFullException extends Exception {
    public ParkingLotFullException(String parkingIsFull) {
        super(parkingIsFull);
    }

}
