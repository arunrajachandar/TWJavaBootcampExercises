package com.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {

    private int capacity;


    private List<Vehicle> vehicleList = new ArrayList<>(capacity);

    private List<ParkingLotObserver> parkingLotObservers;


    public ParkingSpace(int capacity) {
        this.capacity = capacity;
        this.parkingLotObservers = null;
    }

    public ParkingSpace(int capacity, List<ParkingLotObserver> plos) {
        this.capacity = capacity;
        this.parkingLotObservers = plos;
    }


    public void parkVehicle(Vehicle vehicle) throws ParkingLotFullException {
        if(isSpaceFull()) {
            throw new ParkingLotFullException("Parking is Full");
        }
        this.vehicleList.add(vehicle);
        if(isSpaceFull() && parkingLotObservers != null) {
            for(ParkingLotObserver plo: parkingLotObservers) {
                plo.notifyIfFull();
            }
        }

    }

    public Boolean isSpaceFull() {
        return this.capacity == vehicleList.size();
    }

    public void unParkVehicle(int licensePlateNumber) {

        this.vehicleList.removeIf(p -> p.getLicensePlate() == licensePlateNumber);
        if(isSpaceAvailable() && parkingLotObservers != null) {
            for(ParkingLotObserver plo: parkingLotObservers) {
                plo.notifyIfAvailable();
            }
        }
    }

    private boolean isSpaceAvailable() {
        return vehicleList.size() <= this.capacity - 1;
    }

    public Boolean equals(ParkingSpace that) {
        return this == that;
    }


    public int getParkedSpaces() {
        return this.vehicleList.size();
    }

    public int getFreeSpace() {
        return this.capacity - getParkedSpaces();
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "capacity=" + capacity +
                ", vehicleList=" + vehicleList +
                '}';
    }
}
