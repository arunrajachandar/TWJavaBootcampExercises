package com.parkingLot;

public interface Observer {
    void notifyIfFull();
    void notifyIfAvailable();
}
