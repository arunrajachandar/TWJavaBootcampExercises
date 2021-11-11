package com.measurements;

public class Measurements {
    public double getMagnitude() {
        return magnitude;
    }

    public Units getUnit() {
        return unit;
    }

    private Measurements(double magnitude, Units unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public static Measurements centimeters(double mag) {
        return new Measurements(mag, Units.CENTI_METERS);
    }

    public static Measurements meters(double mag) {
        return new Measurements(mag, Units.METERS);
    }

    public static Measurements kilometers(double mag) {
        return new Measurements(mag, Units.KILO_METERS);
    }
    public static Measurements milligrams(double mag) {
        return new Measurements(mag, Units.MILLI_GRAMS);
    }



    public boolean equalVal(Measurements secondVal) {
        if(this.unit.getType() != secondVal.getUnit().getType()) {
            throw new RuntimeException("Not equal");
        }
        return this.unit.toConvertToCMs(this.magnitude) == secondVal.getUnit().toConvertToCMs(secondVal.getMagnitude());
    }

    public double add(Measurements secondVal) {
        if(this.unit.getType() != secondVal.getUnit().getType()) {
            throw new RuntimeException("Not equal");
        }
        return (this.unit.toConvertToCMs(this.magnitude)+secondVal.getUnit().toConvertToCMs(secondVal.getMagnitude()))/this.unit.getBaseMetric();
    }

    private double magnitude;
    private Units unit;

    public static void main(String[] args) {
        System.out.println(Measurements.centimeters(100).equalVal(Measurements.meters(1)));
        System.out.println(Measurements.kilometers(1).add(Measurements.meters(1000)));
        System.out.println(Measurements.centimeters(100).add(Measurements.meters(1)));
        System.out.println(Measurements.milligrams(100).add(Measurements.meters(1)));
    }

}



