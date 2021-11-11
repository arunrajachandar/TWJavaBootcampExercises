package com.parkingLot;

public class ParkingLotObserver implements Observer{
    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    private ParkingLotObserverType parkingLotObserverType;
    private ParkingLotStatus parkingLotStatus;

    private ParkingLotObserver(ParkingLotObserverType type) {
        this.parkingLotObserverType = type;
    }

    public static ParkingLotObserver owner() {
        return new ParkingLotObserver(ParkingLotObserverType.OWNER);
    }

    public static ParkingLotObserver attendant() {
        return new ParkingLotObserver(ParkingLotObserverType.ATTENDANT);
    }

    public void notifyIfFull() {
        this.parkingLotStatus = ParkingLotStatus.RED;
    }

    public void notifyIfAvailable() {
        this.parkingLotStatus = ParkingLotStatus.GREEN;
    }
}
